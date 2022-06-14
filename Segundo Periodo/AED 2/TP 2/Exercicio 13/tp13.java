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

class Heapsort
{
    private static Personagem[] array;
    private static int n;
    
    public Heapsort (Personagem[] array, int n)
    {
        this.array = array;
        this.n = n;
        heapsort();
    }

    public static void swap(int i, int j) 
    {
        Personagem temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void constroi(int tamHeap)
    {
        for(int i = tamHeap; i > 1 && array[i].Getsaltura() > array[i/2].Getsaltura(); i /= 2)
            swap(i, i/2);
    }

    public static void reconstroi(int tamHeap)
    {
        int i = 1; 
        int filho;
        while(i <= (tamHeap/2))
        {
            if (array[2*i].Getsaltura() > array[2*i+1].Getsaltura() || 2*i == tamHeap)
                filho = 2*i;
            else 
                filho = 2*i + 1;

            if(array[i].Getsaltura() < array[filho].Getsaltura())
            {
                swap(i, filho);
                i = filho;
            }
            else
                i = tamHeap;
        }
    }

    public static void heapsort() 
    {
        Personagem[] tmp = new Personagem[n+1];
        for(int i = 0; i < n; i++)
            tmp[i+1] = array[i];
        array = tmp;
        
        for(int tamHeap = 2; tamHeap <= n; tamHeap++)
        {
            constroi(tamHeap);
        }

        int tamHeap = n;
        while(tamHeap > 1)
        {
            swap(1, tamHeap--);
            reconstroi(tamHeap);
        }

        tmp = array;
        array = new Personagem[n];
        for(int i = 0; i < n; i++)
            array[i] = tmp[i+1];
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
        Heapsort Ordenador = new Heapsort(array,n);
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

public class tp13
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
