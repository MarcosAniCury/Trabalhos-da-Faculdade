// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package mvc.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mvc.controle.ControladorAlunoSerializado;
import mvc.controle.DataInvalidaException;
import mvc.controle.DreDuplicadoException;
import mvc.modelo.Aluno;

public class GuiSimplesSalvando 
{
    private String dre, nome, telefone, endereco, dataNasc;
    private JFrame janela;
    private JPanel painelGeral, pCentro, pDisplay, pDre, pNome, pTelefone, pEndereco, pDataNasc, pBotoes, pMensagem;
    private JLabel labelDre, labelNome, labelTelefone, labelEndereco, labelDataNasc, labelMensagem;
    private JButton botCriar, botObterNome, botSalvar, botAlterar, botLimparAluno, botLimpar;
    private JTextField tfDre, tfNome, tfTelefone, tfEndereco, tfDataNasc, tfMensagem;
    private ControladorAlunoSerializado controlador = ControladorAlunoSerializado.getControladorAlunoSerializado();
    
    public GuiSimplesSalvando() 
    {
        janela = new JFrame("GUI Simples Persistente");

        painelGeral = new JPanel(new BorderLayout());
        pCentro = new JPanel(new BorderLayout());
        pDisplay = new JPanel(new GridLayout(6,1));

        pDre = new JPanel();
        pNome = new JPanel();
        pTelefone = new JPanel();
        pEndereco = new JPanel();
        pDataNasc = new JPanel();
        pMensagem = new JPanel();

        pDre.setLayout(new FlowLayout(FlowLayout.LEFT));
        pNome.setLayout(new FlowLayout(FlowLayout.LEFT));
        pTelefone.setLayout(new FlowLayout(FlowLayout.LEFT));
        pEndereco.setLayout(new FlowLayout(FlowLayout.LEFT));
        pDataNasc.setLayout(new FlowLayout(FlowLayout.LEFT));
        pMensagem.setLayout(new FlowLayout(FlowLayout.LEFT));

        pDisplay.add(pDre);
        pDisplay.add(pNome);
        pDisplay.add(pTelefone);
        pDisplay.add(pEndereco);
        pDisplay.add(pDataNasc);

        labelDre = new JLabel("DRE: ");
        labelNome = new JLabel("Nome: ");
        labelTelefone = new JLabel("Telefone: ");
        labelEndereco = new JLabel("Endereco: ");
        labelDataNasc = new JLabel("Data de Nascimento: ");
        labelMensagem = new JLabel("Mensagem: ");

        pDre.add(labelDre);
        tfDre = new JTextField(10);
        tfDre.addKeyListener(new OuvinteTfDre());
        pDre.add(tfDre);

        pNome.add(labelNome);
        tfNome = new JTextField(30);
        pNome.add(tfNome);

        pTelefone.add(labelTelefone);
        tfTelefone = new JTextField(11);
        pTelefone.add(tfTelefone);

        pEndereco.add(labelEndereco);
        tfEndereco = new JTextField(50);
        pEndereco.add(tfEndereco);

        pDataNasc.add(labelDataNasc);
        tfDataNasc = new JTextField(10);
        tfDataNasc.addKeyListener(new OuvinteTfDataNasc());
        pDataNasc.add(tfDataNasc);

        pBotoes = new JPanel();
        botCriar = new JButton("Criar Aluno");
        botCriar.addActionListener(new OuvinteCriar());
        pBotoes.add(botCriar);

        botObterNome = new JButton("Obter dados");
        botObterNome.addActionListener(new OuvinteObterDados());
        pBotoes.add(botObterNome);

        botSalvar = new JButton("Salvar dados");
        botSalvar.addActionListener(new OuvinteSalvar());
        pBotoes.add(botSalvar);

        botAlterar = new JButton("Alterar dados");
        botAlterar.addActionListener(new OuvinteAlterar());
        pBotoes.add(botAlterar);

        botLimparAluno = new JButton("Limpar aluno");
        botLimparAluno.addActionListener(new OuvinteLimparAluno());
        pBotoes.add(botLimparAluno);

        botLimpar = new JButton("Limpar dados");
        botLimpar.addActionListener(new OuvinteLimpar());
        pBotoes.add(botLimpar);

        tfMensagem = new JTextField(40);
        tfMensagem.setEditable(false);
        pMensagem.add(labelMensagem);
        pMensagem.add(tfMensagem);

        pCentro.add(pDisplay, BorderLayout.CENTER);
        pCentro.add(pBotoes, BorderLayout.SOUTH);
        painelGeral.add(pCentro, BorderLayout.CENTER);
        painelGeral.add(pMensagem, BorderLayout.SOUTH);

        janela.add(painelGeral);
        janela.setBounds(0, 0, 800, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        try {
            controlador.recuperarAlunos();
            tfMensagem.setText("Os dados dos alunos foram recuperados do arquivo");
        } catch (IOException ioe) {
            tfMensagem.setText
            ("Não foi possível recuperar os dados dos alunos: IOException");
        } catch (ClassNotFoundException cnf) {
            tfMensagem.setText
            ("Não foi possível recuperar os dados dos alunos: ClassNotFoundException");
        }
    }

    //Listener feito para limpar os campos caso seja digitado um novo Dre
    class OuvinteTfDre extends KeyAdapter
    {
        @Override
        public void keyTyped(KeyEvent ev)
        {
            tfMensagem.setText("");
            tfNome.setText("");
            tfTelefone.setText("");
            tfEndereco.setText("");
            tfDataNasc.setText("");
        }
    }

    //Listener para adicionar uma mascara simple ao campo de data
    class OuvinteTfDataNasc extends KeyAdapter
    {
        private final int posPrimeiraBarra = 2;
        private final int posSegundaBarra = 5;
        private final int tamMax = 10;

        @Override
        public void keyTyped(KeyEvent ev)
        {
            StringBuffer tfDataNascMask = new StringBuffer(tfDataNasc.getText());
            if (tfDataNascMask.length() > posPrimeiraBarra &&
                tfDataNascMask.charAt(posPrimeiraBarra) != '/') {
                tfDataNascMask.insert(posPrimeiraBarra, '/');
            }

            if (tfDataNascMask.length() > posSegundaBarra &&
                tfDataNascMask.charAt(posSegundaBarra) != '/') {
                tfDataNascMask.insert(posSegundaBarra, '/');
            }

            if (tfDataNascMask.length() > tamMax-1) {
                ev.consume();
            }
            tfDataNasc.setText(tfDataNascMask.toString());
        }
    }

    //Listener para criar o aluno com base nos dados digitados
    class OuvinteCriar implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent aev)
        {
            nome = tfNome.getText();
            dre = tfDre.getText();
            telefone = tfTelefone.getText();
            endereco = tfEndereco.getText();
            dataNasc = tfDataNasc.getText();

            try {
                Date dataNascTrans = stringToDate(dataNasc);
                controlador.criaAluno(dre, nome, telefone, endereco, dataNascTrans);
                tfMensagem.setText("Aluno " + nome + " criado OK, com DRE " + dre);
            } catch(DreDuplicadoException ex) {
                tfMensagem.setText("Não foi possível criar o aluno. O DRE " + dre + " já foi alocado");
            } catch (DataInvalidaException ex) {
                tfMensagem.setText("Data inserida inválida, digite novamente");
            }
        }
    }

    /**Listener para obter o aluno com os dados do DRE
     * 
     * IMPORTANTE, A PARTIR DE AGORA OS DADOS SAO RECUPERADOS NOS PROPRIOS CAMPOS
     * 
     * */
    class OuvinteObterDados implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent aev)
        {
            try 
            {
                dre = tfDre.getText();
                Aluno aluno = controlador.getAluno(dre);

                tfNome.setText(aluno.getNome());
                tfTelefone.setText(aluno.getTelefone());
                tfEndereco.setText(aluno.getEndereco());
                tfDataNasc.setText(dateToString(aluno.getDataNasc()));
                
                tfMensagem.setText("Dados recuperados nos campos");
            } 
            catch (mvc.controle.AlunoInexistenteException ex) {
                tfMensagem.setText("Falha ao recuperar os dados");
            }
        }
    }

    class OuvinteSalvar implements ActionListener
    {
        public void actionPerformed(ActionEvent aev)
        {
            try
            {
                controlador.salvarAlunos();
                tfMensagem.setText("Dados dos alunos salvos com sucesso");
            }
            catch (IOException ioe)
            {
                tfMensagem.setText("Não foi possível salvar os dados dos alunos no arquivo");
            }
        }
    }

    class OuvinteAlterar implements ActionListener
    {
        public void actionPerformed(ActionEvent aev)
        {
            dre = tfDre.getText();
            nome = tfNome.getText();
            telefone = tfTelefone.getText();
            endereco = tfEndereco.getText();
            dataNasc = tfDataNasc.getText();
            Date date;

            try {
                date = stringToDate(dataNasc);

                if (dre != null && !dre.equals("")) {
                    controlador.alterarAluno(new Aluno(dre, nome, telefone, endereco, date));
                    tfMensagem.setText("Dado alterado e salvo na cache com sucesso");
                } else {
                    throw new Exception();
                }
            } catch (DataInvalidaException ex) {
                tfMensagem.setText("Data inserida inválida, digite novamente");
            } catch (Exception ex) {
                tfMensagem.setText("Falha na alteracao dos dados");
            }
        }
    }

    class OuvinteLimpar implements ActionListener
    {
        public void actionPerformed(ActionEvent aev)
        {
            controlador.limparDados();
        }
    }

    class OuvinteLimparAluno implements ActionListener
    {
        public void actionPerformed(ActionEvent aev)
        {
            dre = tfDre.getText();

            try {
                if (dre != null && !dre.equals("")) {
                    controlador.limparAluno(dre);
                    controlador.salvarAlunos();
                    tfMensagem.setText("Aluno com o dre = "+ dre + " foi excluido da base de dados");
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                tfMensagem.setText("Falha na alteracao dos dados");
            }
        }
    }

    public Date stringToDate(String dataNasc) throws DataInvalidaException
    {
        String[] data = dataNasc.split("/");
        Date date;
        try {
            String newDate = data[2] + '-' + data[1] + '-' + data[0];
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(newDate);
        } catch (Exception e) {
            throw new DataInvalidaException();
        }
        return date;
    }

    public String dateToString(Date dataNasc)
    {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String newDate = df.format(dataNasc);
        return newDate;
    }
    
    public static void main(String[] args) 
    {
        new GuiSimplesSalvando();
    }
}
