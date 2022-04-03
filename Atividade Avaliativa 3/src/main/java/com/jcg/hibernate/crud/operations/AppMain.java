package com.jcg.hibernate.crud.operations;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain {
	public static void main(String [] args) {
		TelaInicial tela = new TelaInicial();
		tela.setVisible(true);
	}
}

class TelaInicial extends JFrame implements ActionListener
{
	private JPanel contentPane;

	private JButton btnInstituicao;
	private JButton btnVeiculoDePublicacao;
	private JButton btnArtigo;
	private JButton btnPesquisador;

	//Telas Adversas
	private TelaCadastroInstituicao cadastroInstituicao = new TelaCadastroInstituicao(this);
	private TelaVeiculoDePublicacao cadastroVeiculoDePublicacao = new TelaVeiculoDePublicacao(this);
	private TelaArtigo cadastroArtigo = new TelaArtigo(this);

	//Constants
	private final String SCREEN_TITLE = "Tela Inicial";
	private final String BNT_INSTITUICAO = "Cadastrar Instituicao";
	private final String BNT_VEICULO_DE_PUBLICACAO = "Cadastrar Veiculo de Publicacao";
	private final String BNT_ARTIGO = "Cadastrar Artigo";
	private final String BNT_PESQUISADOR = "Cadastrar Pesquisador";

	public TelaInicial()
	{
		setTitle(SCREEN_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 400);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2,2));

		btnInstituicao = new JButton(BNT_INSTITUICAO);
		btnInstituicao.setBounds(440, 327, 150, 23);
		btnInstituicao.addActionListener(this);
		btnInstituicao.setActionCommand(BNT_INSTITUICAO);
		contentPane.add(btnInstituicao);

		btnVeiculoDePublicacao = new JButton(BNT_VEICULO_DE_PUBLICACAO);
		btnVeiculoDePublicacao.setBounds(440, 327, 150, 23);
		btnVeiculoDePublicacao.addActionListener(this);
		btnVeiculoDePublicacao.setActionCommand(BNT_VEICULO_DE_PUBLICACAO);
		contentPane.add(btnVeiculoDePublicacao);

		btnArtigo = new JButton(BNT_ARTIGO);
		btnArtigo.setBounds(440, 327, 150, 23);
		btnArtigo.addActionListener(this);
		btnArtigo.setActionCommand(BNT_ARTIGO);
		contentPane.add(btnArtigo);

		btnPesquisador = new JButton(BNT_PESQUISADOR);
		btnPesquisador.setBounds(440, 327, 150, 23);
		btnPesquisador.addActionListener(this);
		btnPesquisador.setActionCommand(BNT_PESQUISADOR);
		contentPane.add(btnPesquisador);
	}

	public void actionPerformed(ActionEvent e)
	{
		//Se o botao instituicao for acionado
		if(e.getActionCommand().equals(this.btnInstituicao.getActionCommand())){
			this.setVisible(false);
			cadastroInstituicao.setVisible(true);
		} else if (e.getActionCommand().equals(this.btnVeiculoDePublicacao.getActionCommand())) {
			this.setVisible(false);
			cadastroVeiculoDePublicacao.setVisible(true);
		} else if (e.getActionCommand().equals(this.btnArtigo.getActionCommand())) {
			this.setVisible(false);
			cadastroArtigo.setVisible(true);
		} else if (e.getActionCommand().equals(this.btnPesquisador.getActionCommand())) {
			this.setVisible(false);
			new TelaContato().setVisible(true);
		}
	}
}

class TelaCadastroInstituicao extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;

	private JButton btnVoltar;
	private JButton btnCadastrar;

	//Tela Adversas
	TelaInicial home;

	//Constants
	private final String SCREEN_TITLE = "Cadastro de Instituicao";
	private final String BNT_VOLTAR = "Voltar";
	private final String BNT_CADASTRAR = "Cadastrar";
	private final String LABEL_CODIGO = "Codigo:";
	private final String LABEL_NOME = "Nome:";

	public TelaCadastroInstituicao(TelaInicial home)
	{
		this.home = home;

		setTitle(SCREEN_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 413);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

		btnVoltar = new JButton(BNT_VOLTAR);
		btnVoltar.setBounds(0, 0, 150, 23);
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand(BNT_VOLTAR);
		contentPane.add(btnVoltar);

		JLabel lblCodigo = new JLabel(LABEL_CODIGO);
		lblCodigo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblCodigo.setBounds(10, 31, 109, 14);
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtCodigo.setBounds(129, 76, 283, 20);
		txtCodigo.setColumns(10);
		contentPane.add(txtCodigo);

		JLabel lblNome = new JLabel(LABEL_NOME);
		lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblNome.setBounds(10, 79, 109, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtNome.setBounds(129, 76, 283, 20);
		txtNome.setColumns(10);
		contentPane.add(txtNome);

		btnCadastrar = new JButton(BNT_CADASTRAR);
		btnCadastrar.setBounds(0, 0, 150, 23);
		btnCadastrar.addActionListener(this);
		btnCadastrar.setActionCommand(BNT_CADASTRAR);
		contentPane.add(btnCadastrar);
	}

	public void actionPerformed(ActionEvent e)
	{
		//Se o botao voltar
		if(e.getActionCommand().equals(this.btnVoltar.getActionCommand())){
			this.setVisible(false);
			home.setVisible(true);
		}
	}
}

class TelaVeiculoDePublicacao extends JFrame implements ActionListener
{
	TelaInicial home;

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JTextField txtLocal;

	private JButton btnVoltar;
	private JButton btnCadastrar;

	//Constants
	private final String SCREEN_TITLE = "Cadastro de Instituicao";
	private final String BNT_VOLTAR = "Voltar";
	private final String LABEL_CODIGO = "Codigo:";
	private final String LABEL_TITULO = "Titulo:";
	private final String LABEL_LOCAL = "Local:";
	private final String BNT_CADASTRAR = "Cadastrar";

	TelaVeiculoDePublicacao(TelaInicial home)
	{
		this.home = home;

		setTitle(SCREEN_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 413);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

		btnVoltar = new JButton(BNT_VOLTAR);
		btnVoltar.setBounds(0, 0, 150, 23);
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand(BNT_VOLTAR);
		contentPane.add(btnVoltar);

		JLabel lblCodigo = new JLabel(LABEL_CODIGO);
		lblCodigo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblCodigo.setBounds(10, 31, 109, 14);
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtCodigo.setBounds(129, 76, 283, 20);
		txtCodigo.setColumns(10);
		contentPane.add(txtCodigo);

		JLabel lblTitulo = new JLabel(LABEL_TITULO);
		lblTitulo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblTitulo.setBounds(10, 31, 109, 14);
		contentPane.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtTitulo.setBounds(129, 76, 283, 20);
		txtTitulo.setColumns(10);
		contentPane.add(txtTitulo);

		JLabel lblLocal = new JLabel(LABEL_LOCAL);
		lblLocal.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblLocal.setBounds(10, 31, 109, 14);
		contentPane.add(lblLocal);

		txtLocal = new JTextField();
		txtLocal.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtLocal.setBounds(129, 76, 283, 20);
		txtLocal.setColumns(10);
		contentPane.add(txtLocal);

		btnCadastrar = new JButton(BNT_CADASTRAR);
		btnCadastrar.setBounds(0, 0, 150, 23);
		btnCadastrar.addActionListener(this);
		btnCadastrar.setActionCommand(BNT_CADASTRAR);
		contentPane.add(btnCadastrar);
	}

	public void actionPerformed(ActionEvent e)
	{
		//Se o botao voltar
		if(e.getActionCommand().equals(this.btnVoltar.getActionCommand())){
			this.setVisible(false);
			home.setVisible(true);
		} else if (e.getActionCommand().equals(this.btnCadastrar.getActionCommand())) {
			this.setVisible(false);
		}
	}
}

class TelaArtigo extends JFrame implements ActionListener
{
	TelaInicial home;

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtTitulo;
	private JComboBox cbVeiculoDePublicacao;
	private JTextField txtPaginaInicial;
	private JTextField txtPaginaFinal;

	private JButton btnVoltar;
	private JButton btnCadastrar;

	//Constants
	private final String SCREEN_TITLE = "Cadastro de Instituicao";
	private final String BNT_VOLTAR = "Voltar";
	private final String LABEL_CODIGO = "Codigo:";
	private final String LABEL_TITULO = "Titulo:";
	private final String LABEL_VEICULO_DE_PUBLICACAO = "Veiculo de publicacao:";
	private final String LABEL_PAGINA_INICIAL = "Pagina Inicial:";
	private final String LABEL_PAGINA_FINAL = "Pagina Final:";
	private final String BNT_CADASTRAR = "Cadastrar";

	public TelaArtigo(TelaInicial home)
	{
		this.home = home;

		setTitle(SCREEN_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 413);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));

		btnVoltar = new JButton(BNT_VOLTAR);
		btnVoltar.setBounds(0, 0, 150, 23);
		btnVoltar.addActionListener(this);
		btnVoltar.setActionCommand(BNT_VOLTAR);
		contentPane.add(btnVoltar);

		JLabel lblCodigo = new JLabel(LABEL_CODIGO);
		lblCodigo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblCodigo.setBounds(10, 31, 109, 14);
		contentPane.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtCodigo.setBounds(129, 76, 283, 20);
		txtCodigo.setColumns(10);
		contentPane.add(txtCodigo);

		JLabel lblTitulo = new JLabel(LABEL_TITULO);
		lblTitulo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblTitulo.setBounds(10, 31, 109, 14);
		contentPane.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtTitulo.setBounds(129, 76, 283, 20);
		txtTitulo.setColumns(10);
		contentPane.add(txtTitulo);

		JLabel lblVeiculoDePublicacao = new JLabel(LABEL_VEICULO_DE_PUBLICACAO);
		lblVeiculoDePublicacao.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblVeiculoDePublicacao.setBounds(10, 31, 109, 14);
		contentPane.add(lblVeiculoDePublicacao);

		cbVeiculoDePublicacao = new JComboBox();
		cbVeiculoDePublicacao.setEditable(true);
		cbVeiculoDePublicacao.setBounds(129, 28, 283, 20);
		contentPane.add(cbVeiculoDePublicacao);

		JLabel lblPaginaInicial = new JLabel(LABEL_PAGINA_INICIAL);
		lblTitulo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblTitulo.setBounds(10, 31, 109, 14);
		contentPane.add(lblPaginaInicial);

		txtPaginaInicial = new JTextField();
		txtPaginaInicial.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtPaginaInicial.setBounds(129, 76, 283, 20);
		txtPaginaInicial.setColumns(10);
		contentPane.add(txtPaginaInicial);

		JLabel lblPaginaFinal = new JLabel(LABEL_PAGINA_FINAL);
		lblPaginaFinal.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblPaginaFinal.setBounds(10, 31, 109, 14);
		contentPane.add(lblPaginaFinal);

		txtPaginaFinal = new JTextField();
		txtPaginaFinal.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtPaginaFinal.setBounds(129, 76, 283, 20);
		txtPaginaFinal.setColumns(10);
		contentPane.add(txtPaginaFinal);

		btnCadastrar = new JButton(BNT_CADASTRAR);
		btnCadastrar.setBounds(0, 0, 150, 23);
		btnCadastrar.addActionListener(this);
		btnCadastrar.setActionCommand(BNT_CADASTRAR);
		contentPane.add(btnCadastrar);
	}

	public void actionPerformed(ActionEvent e)
	{
		//Se o botao voltar
		if(e.getActionCommand().equals(this.btnVoltar.getActionCommand())){
			this.setVisible(false);
			home.setVisible(true);
		} else if (e.getActionCommand().equals(this.btnCadastrar.getActionCommand())) {
			this.setVisible(false);
		}
	}
}

class TelaContato extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;

	private JTextField txtTel;
	private String txtID;
	private JComboBox cbPesquisar;
	private ButtonGroup bt = new ButtonGroup();


	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnEditar;
	private JButton btnPesquisar;
	private JButton btnLimpar;

	public TelaContato() {
		setTitle("Cadastro de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblPesquisar.setBounds(10, 31, 109, 14);
		contentPane.add(lblPesquisar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblNome.setBounds(10, 79, 109, 14);
		contentPane.add(lblNome);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblEndereo.setBounds(10, 104, 109, 14);
		contentPane.add(lblEndereo);

		JLabel lblTel = new JLabel("Telefone:");
		lblTel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		lblTel.setBounds(10, 129, 109, 14);
		contentPane.add(lblTel);

		cbPesquisar = new JComboBox();
		cbPesquisar.setEditable(true);
		cbPesquisar.setBounds(129, 28, 283, 20);

		contentPane.add(cbPesquisar);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtNome.setBounds(129, 76, 283, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtEndereco.setBounds(129, 101, 365, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);



		try {
			txtTel = new JTextField();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtTel.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
		txtTel.setBounds(129, 126, 143, 20);
		contentPane.add(txtTel);



		btnSalvar = new JButton("Incluir");
		btnSalvar.setBounds(193, 327, 75, 23);
		btnSalvar.addActionListener(this);
		btnSalvar.setActionCommand("salvar");
		contentPane.add(btnSalvar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(280, 327, 75, 23);
		btnEditar.setText("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setActionCommand("editar");
		contentPane.add(btnEditar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(360, 327, 75, 23);
		btnLimpar.setText("Limpar");
		btnLimpar.addActionListener(this);
		btnLimpar.setActionCommand("limpar");
		contentPane.add(btnLimpar);

		btnExcluir = new JButton("");
		btnExcluir.setBounds(440, 327, 75, 23);
		btnExcluir.setText("Excluir");
		btnExcluir.addActionListener(this);
		btnExcluir.setActionCommand("excluir");
		contentPane.add(btnExcluir);

		btnPesquisar = new JButton("Buscar");
		btnPesquisar.setBounds(422, 22, 80, 23);
		btnPesquisar.addActionListener(this);
		btnPesquisar.setActionCommand("pesquisar");
		contentPane.add(btnPesquisar);
		txtID = "";
		this.carregaLista();
	}
	public Contato montaContato(){
		//Pega os dados digitados nos campos do formulário e atribui ao objeto da classe Contato;
		Contato c = new Contato();
		c.setNome(this.txtNome.getText());
		c.setEndereco(this.txtEndereco.getText());
		c.setTelefone(this.txtTel.getText());
		return c;
	}
	public Contato editaContato(int i){
		//Pega os dados digitados nos campos do formulário e atribui ao objeto da classe Contato;
		Contato c = new Contato();
		c.setId(i);
		c.setNome(this.txtNome.getText());
		c.setEndereco(this.txtEndereco.getText());
		c.setTelefone(this.txtTel.getText());
		return c;
	}
	public void carregaContatonaTela(Contato c2){
		//Pega os dados digitados nos campos do formulário e atribui ao objeto da classe Contato;
//		this.txtNome.setText(c2.getNome());
		this.txtEndereco.setText(c2.getEndereco());
		this.txtTel.setText(c2.getTelefone());

	}

	public void limpaTela(){
		for(int i = 0; i < contentPane.getComponentCount(); i++){
			//laço de repetição percorrendo o contentPane - JPanel, o painel principal do form
			Component c = contentPane.getComponent(i);
			//Cria um objeto Component c que recebe o componente na posição i do laço for
			if(c instanceof JTextField){ //se o componente c for uma instância de JTextField
				JTextField campo = (JTextField) c;
				//cria uma variável JTextField recebendo o componente c com um cast
				campo.setText(null);
				//apaga o conteúdo do campo JTextField;
			}
		}

	}
	public void carregaLista(){
		//Preenche Combobox com registros do banco de dados
//		controle.ContatoCT mbc = new ContatoCT();
//
//		List<Contato> ContatoBd = mbc.getContatos();
//		cbPesquisar.removeAllItems();
//		for (Contato contato : ContatoBd) {
//			cbPesquisar.addItem(contato.getNome());
//		}
	}

	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals(this.btnSalvar.getActionCommand())){
//			//Condicional - se clicar no botão Salvar ...
//			Contato c = this.montaContato();
//			//Chama o método montaContato para pegar os dados e gravar no objeto c;
//			controle.ContatoCT cbc;
//			cbc = new ContatoCT();
//			//Instancia a classe de controle ContatoCT;
//			cbc.insert(c);
//			//Chama o método insert da classe ContatoCT para inserir os dados do objeto Contato (c) de montaContato no banco;
//			this.limpaTela();
//			//Limpa os campos após inserir/salvar dados no banco;
//			this.carregaLista();
//			//Carrega a lista do combobox, atualizando após inserção;
//			JOptionPane.showMessageDialog(null, "Contato "+txtNome.getText()+" cadastrado...");
//			//Abre diálogo de mensagem, informando que o cliente foi cadastrado;
//		} else
//		if(e.getActionCommand().equals(this.btnPesquisar.getActionCommand())){
//			//Condicional - se clicar no botão buscar ...
//			controle.ContatoCT cbc = new ContatoCT();
//			//Instancia a classe de controle ContatoCT;
//			String nomeDigitado = cbPesquisar.getSelectedItem().toString().trim();
//			Contato cbusca = cbc.select(nomeDigitado);
//			if  (cbusca.getNome().equals(nomeDigitado))
//			{ JOptionPane.showMessageDialog(null, "Contato encontrado!");
//				this.carregaContatonaTela(cbusca);}
//			else
//			{      JOptionPane.showMessageDialog(null, "Contato nao cadastrado...");
//
//			}
//		} else
//		if(e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
//			this.limpaTela();
//		} else
//		if(e.getActionCommand().equals(this.btnExcluir.getActionCommand())){
//			//Condicional - se clicar no botão buscar ...
//			controle.ContatoCT cbc = new ContatoCT();
//			//Instancia a classe de controle ContatoCT;
//
//			Contato cbusca = cbc.select(cbPesquisar.getSelectedItem().toString());
//			if  (cbusca==null)
//				JOptionPane.showMessageDialog(null, "Contato nao cadastrado...");
//			else
//
//			{ JOptionPane.showMessageDialog(null, "Contato excluido!");
//				this.carregaContatonaTela(cbusca);
//				cbc.delete(cbusca);
//				this.limpaTela();
//				this.carregaLista();
//			}
//		}
//		if(e.getActionCommand().equals(this.btnEditar.getActionCommand())){
//			//Condicional - se clicar no botão buscar ...
//			controle.ContatoCT cbc = new ContatoCT();
//			//Instancia a classe de controle ContatoCT;
//
//			Contato cbusca = cbc.select(cbPesquisar.getSelectedItem().toString());
//			if  (cbusca==null)
//				JOptionPane.showMessageDialog(null, "Contato nao cadastrado...");
//			else
//
//			{ JOptionPane.showMessageDialog(null, "Contato editado!");
//
//				cbc.update(this.editaContato(cbusca.getId()));
//				this.limpaTela();
//				this.carregaLista();
//			}
//		}


	}
}