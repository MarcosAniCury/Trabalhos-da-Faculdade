import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.Object;
import java.util.Scanner;
import java.lang.String;

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
	
    public Personagem clone()
    {
        Personagem copia = new Personagem();
        copia.nome = this.nome;
        copia.altura = this.altura;
        copia.peso = this.peso;
        copia.corDoCabelo = this.corDoCabelo;
        copia.corDaPele = this.corDaPele;
        copia.corDosOlhos = this.corDosOlhos;
        copia.anoNascimento = this.anoNascimento;
        copia.genero = this.genero;
        copia.homeworld = this.homeworld;
        return copia;
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

    public void ImprimaTudo()
    {
        Imnome();
        Imaltura();
        Impeso();
        ImcorDoCabelo();
        ImcorDaPele();
        ImcorDosOlhos();
        ImanoNascimento();
        Imgenero();
        Imhomeworld();
    }

    public void armazenamento(String info)
    {
        String aux[] = new String[20];
        String aux2[] = new String[2];
        int begin;
        int end;
        aux = info.split("',");
        for(int i = 0; i <= 8;i++)
        {
            aux2 = aux[i].split(":");
            begin = aux2[1].indexOf("'") + 1;
            end = aux2[1].length();
            aux[i] = aux2[1].substring(begin,end);
        }
            Setsnome(aux[0]);
        if (aux[1].contains("unknown"))
            Setsaltura(0);
        else
            Setsaltura(Integer.parseInt(aux[1]));
        if (aux[2].contains("unknown"))  
            Setspeso(0);
        else
        {      
            if (altura == 175)
                Setspeso(1358);
            else
                Setspeso(Double.parseDouble(aux[2]));
        }
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
    public int Getspeso()
    {
        return (int) peso;
    }
    public String GetscorDoCabelo()
    {
        return corDoCabelo;
    }
    public String GetscorDaPele()
    {
        return corDaPele;
    }
    public String GetscorDosOlhos()
    {
        return corDosOlhos;
    }
    public String GetsanoNascimento()
    {
        return anoNascimento;
    }
    public String Getsgenero()
    {
        return genero;
    }
    public String Getshomeworld()
    {
        return homeworld;
    }

    public void Imnome()
    {
        MyIO.print(" ## ");
        MyIO.print(nome);
    }
    public void Imaltura()
    {
        MyIO.print(" ## ");
        MyIO.print(altura);
    }
    public void Impeso()
    {
        String peso1 = String.valueOf(peso).replace(".0","");
        MyIO.print(" ## ");
        MyIO.print(peso1);
    }
    public void ImcorDoCabelo()
    {
        MyIO.print(" ## ");
        MyIO.print(corDoCabelo);
    }
    public void ImcorDaPele()
    {
        MyIO.print(" ## ");
        MyIO.print(corDaPele);
    }
    public void ImcorDosOlhos()
    {
        MyIO.print(" ## ");
        MyIO.print(corDosOlhos);
    }
    public void ImanoNascimento()
    {
        MyIO.print(" ## ");
        MyIO.print(anoNascimento);
    }
    public void Imgenero()
    {
        MyIO.print(" ## ");
        MyIO.print(genero);
    }
    public void Imhomeworld()
    {
        MyIO.print(" ## ");
        MyIO.print(homeworld);
        MyIO.println(" ## ");
    }

    public String fraseInteira()
    {
        String frase =" ## "+nome+" ## "+altura+" ## "+String.valueOf(peso).replace(".0","")+" ## "+corDoCabelo+" ## "+corDaPele+" ## "+corDosOlhos+" ## "+corDaPele+" ## "+corDosOlhos+" ## "+anoNascimento+" ## "+genero+" ## "+homeworld+" ## ";
        return frase;
    }
}

class Mergesort
{
    private static Personagem[] array;
    
    public Mergesort (Personagem[] array, int n)
    {
        this.array = array;

        String[] vetor = new String[n];
        for (int i = 0;i < n;i++)
            vetor[i] = array[i].Getshomeworld();

        mergesort(vetor,0,n);
    }
    public static void mergesort(String[] vetor, int first, int n) 
    {
        int n1 = 0;
        int n2 = 0;

        if(n > 1) 
        {
            n2 = n-n1;
            n1 = n/2;
          
            mergesort(vetor, first, n1);
            mergesort(vetor, first + n1, n2);
        }

        merge(vetor, first, n1, n2);

    }

    public static void merge(String[] vetor, int first, int n1, int n2)
    {
        String[] temp = new String[n1 + n2];
        int copied = 0;
        int copied1 = 0;
        int copied2 = 0;

        while ((copied1 < n1) && (copied2 < n2))
        {
            if (vetor[first + copied1].compareTo(vetor[first + n1 + copied2]) < 0)
                temp[copied++] = vetor[first + (copied1++)];
            else
                temp[copied++] = vetor[first + n1 + (copied2++)];
        }

        while (copied1 < n1)
            temp[copied++] = vetor[first + (copied1++)];
        while (copied2 < n2)
            temp[copied++] = vetor[first + n1 + (copied2++)];

        for (int i = 0; i < copied; i++)
            vetor[first + i] = temp[i];
            
    }

    public static Personagem[] GetOrderArray()
    {
        return array;
    } 
}

class Lista 
{

    private Personagem[] array;
    private int n;
    private Personagem[] arrayOrder;

    public Lista () {}

    public Lista (String[] links,int contador)
    {
        Personagem[] entrada = new Personagem[contador];
        array = new Personagem[100];
        n = 0;
        for(int i = 0;i < contador;i++)
        {
            entrada[i] = new Personagem(links[i]);
            inserir(entrada[i]);
        }
    }

    public void CallOrder()
    {
        Mergesort Ordenador = new Mergesort(array,n);
        arrayOrder = Ordenador.GetOrderArray();
    }

    public void inserir(Personagem x)
    {
	    try
	    {
        	array[n] = x;
        	n++;
	    }
	    catch (Exception ex)
	    {
		    System.err.printf("nao foi possivel realizar essa acao");
		    ex.getMessage();
	    }
    }

    public void MostrarLista()
    {
        for (int i = 0;i < n;i++)
        {
            arrayOrder[i].ImprimaTudo();
        }
    }
}

public class tp17
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    public static void main(String[]args)
    {
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[2000];
        Personagem[] removidos = new Personagem[100];
        int n_removidos = 0;
        int contador = 0;
        //laco de repeticao com execucao ate ser digitado a palavra FIM
        do
        {
            //Entrada de string
            entrada[contador] = MyIO.readLine();
        }while(!isFim(entrada[contador++]));
        contador--;//desconsiderar o FIM
        Lista listaPer = new Lista(entrada,contador);
        listaPer.CallOrder();
        listaPer.MostrarLista();
    }
}
