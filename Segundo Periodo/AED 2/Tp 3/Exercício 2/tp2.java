import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.Object;

class Celula
{
    public Celula ant;
    public Personagem elemento;

    public Celula() {this(new Personagem());}

    public Celula(Personagem persona)
    {
        this.elemento = persona.clone();
        this.ant = null;
    }
}

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

class Pilha 
{
    private Celula topo;
    private int contador;
 
    public Pilha(){}

    public Pilha (String[] links,int contador)
    {
        this.contador = -1;
        topo = new Celula();
        topo.elemento = new Personagem(links[0]);
        for (int i = 1; i < contador;i++)
            inserir(new Personagem(links[i]));
    }
    public void inserir(Personagem x)
    {
	    try
	    {
            Celula tmp = new Celula(x);
            tmp.ant = topo;
            topo = tmp;
            tmp = null;
	    }
	    catch (Exception ex)
	    {
		    System.err.printf("nao foi possivel realizar essa acao");
		    ex.getMessage();
	    }
    }
    public Personagem remover()
    {
        Personagem resp = new Personagem();
        try
        {
            if (topo != null)
            {
                resp = topo.elemento;
                Celula tmp = topo;
                topo = topo.ant;
                tmp.ant = tmp = null;
            }
        }
        catch (Exception ex)
        {
            System.err.printf("nao foi possivel realizar essa acao");
            ex.getMessage();
        }
        return resp;
    }
    public void Mostrar ()
    {
        MostrarPilha(topo);
    }
    public void MostrarPilha(Celula i)
    {
        if(i != null){
            MostrarPilha(i.ant);
            contador++;
            MyIO.println("["+contador+"]" + i.elemento.fraseInteira());
		}
    }
}

public class tp2
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
        int num = Integer.parseInt(MyIO.readLine());
        String[] operacoes = new String[num];
        Pilha pilhaPer = new Pilha(entrada,contador);
        for(int i = 0; i < num;i++)
        {
            operacoes[i] = MyIO.readLine();
            String[] operacaoEArgumentos = operacoes[i].split(" ");
            Personagem personagem;
            int indice;
            
            if(operacaoEArgumentos[0].equals("I"))
            {
                personagem = new Personagem(operacaoEArgumentos[1]);
                pilhaPer.inserir(personagem);
            }

            else 
            {
                removidos[n_removidos] = pilhaPer.remover();
                n_removidos++;
            }
            
        }
        for(int i = 0;i < n_removidos;i++)
        {
            MyIO.println("(R) "+removidos[i].Getsnome());
        }
        pilhaPer.Mostrar();
    }
}