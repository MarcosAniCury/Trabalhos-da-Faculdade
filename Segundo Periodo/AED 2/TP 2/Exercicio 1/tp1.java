import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.Object;

class Personagem 
{
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;
    private String info;

    public Personagem(){}

    public Personagem(String link)
    {
        leitura(link);
    }

    public void leitura(String link)
    {
        String aux = "";

        try
        {
            FileReader arquivo = new FileReader (link);
            BufferedReader larquivo = new BufferedReader(arquivo);
            String informacoes = larquivo.readLine();
            while(informacoes != null)
            {
                aux = aux + informacoes;
                informacoes = larquivo.readLine();
            }
            info = aux;
            larquivo.close();
            arquivo.close();
            armazenamento(info);
        }
        catch(IOException ex)
        {
            System.err.printf("Nao foi possivel continuar essa acao");
            ex.getMessage();
        }
    }

    public void armazenamento(String info)
    {
        String aux[] = new String[20];
        String aux2[] = new String[2];
        int begin;
        int end;
        aux = info.split(",");
        for(int i = 0; i <= 8;i++)
        {
            aux2 = aux[i].split(":");
            begin = aux2[1].indexOf("'") + 1;
            end = aux2[1].lastIndexOf("'");
            aux[i] = aux2[1].substring(begin,end);
        }
            Setsnome(aux[0]);
        if (aux[1] == 'unknown')
            Setsaltura(0);
        else
            Setsaltura(Integer.parseInt(aux[1]));
        if (aux[2] == 'unknown')  
            Setspeso(0);
        else
            Setspeso(Double.parseDouble(aux[2]));
        SetscorDoCabelo(aux[3]);
        SetscorDaPele(aux[4]);
        SetscorDosOlhos(aux[5]);
        SetsanoNascimento(aux[6]);
        Setsgenero(aux[7]);
        Setshomeworld(aux[8]);
    }

    public void Setsnome(String nome)
    {
        this.nome = nome;
    }
    public void Setsaltura(int altura)
    {
        this.altura = altura;
    }
    public void Setspeso(double peso)
    {
        this.peso = peso;
    }
    public void SetscorDoCabelo(String corDoCabelo)
    {
        this.corDoCabelo = corDoCabelo;
    }
    public void SetscorDaPele(String corDaPele)
    {
        this.corDaPele = corDaPele;
    }
    public void SetscorDosOlhos(String corDosOlhos)
    {
        this.corDosOlhos = corDosOlhos;
    }
    public void SetsanoNascimento(String anoNascimento)
    {
        this.anoNascimento = anoNascimento;
    }
    public void Setsgenero(String genero)
    {
        this.genero = genero;
    }
    public void Setshomeworld(String homeworld)
    {
        this.homeworld = homeworld;
    }

    public String Getsnome()
    {
        return nome;
    }
    public int Getsaltura()
    {
        return altura;
    }
    public double Getspeso()
    {
        return peso;
    }
    public String GetscorDoCabelo()
    {
        return corDoCabelo;
    }
    public String GetscorDaPele()
    {
        return corDaPele;
    }
    public String SetscorDosOlhos()
    {
        return corDosOlhos;
    }
    public String SetsanoNascimento()
    {
        return anoNascimento;
    }
    public String Getsgenero()
    {
        return genero;
    }
    public String Setshomeworld()
    {
        return homeworld;
    }

    public void Lernome()
    {
        MyIO.print("## ");
        MyIO.print(nome);
    }
    public void Leraltura()
    {
        MyIO.print("## ");
        MyIO.print(altura);
    }
    public void Lerpeso()
    {
        MyIO.print("## ");
        MyIO.print(peso);
    }
    public void LercorDoCabelo()
    {
        MyIO.print("## ");
        MyIO.print(corDoCabelo);
    }
    public void LercorDaPele()
    {
        MyIO.print("## ");
        MyIO.print(corDaPele);
    }
    public void LercorDosOlhos()
    {
        MyIO.print("## ");
        MyIO.print(corDosOlhos);
    }
    public void LeranoNascimento()
    {
        MyIO.print("## ");
        MyIO.print(anoNascimento);
    }
    public void Lergenero()
    {
        MyIO.print("## ");
        MyIO.print(genero);
    }
    public void Lerhomeworld()
    {
        MyIO.print("## ");
        MyIO.print(homeworld);
        MyIO.print("## ");
    }
}
public class tp1
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    public static void main(String[]args)
    {
        String[] entrada = new String[2000];
        int contador = 0;
        //laco de repeticao com execucao ate ser digitado a palavra FIM
        do
        {
            //Entrada de string
            entrada[contador] = MyIO.readLine();
        }while(!isFim(entrada[contador++]));
        contador--;//desconsiderar o FIM
        Personagem[] iniciar = new Personagem[2000];
        for (int i = 0;i < contador;i++)
        {
            iniciar[i] = new Personagem (entrada[i]);
        }
    }
}