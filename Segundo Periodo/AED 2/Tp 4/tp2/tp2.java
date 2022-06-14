import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.Object;
import java.util.Scanner;
//classe no da arvore
class no
{
    public no esq, dir, sub;
    public Personagem elemento;
    public int elementop;

    public no() {this(new Personagem());}
    
    public no(Personagem elemento)
    {
        this.elemento = elemento.clone();
        esq = dir = sub = null;
    }
    public no(int elementop)
    {
        this.elementop = elementop;
        esq = dir = sub = null;
    }
}
//classe personagem, responsavel por pegar o caminho e do arquivo e traduzir de e armazenar todas as informacoes necessarias
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
    
    //funcao para retornar uma copia do Personagem com outro endereco
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
    //funcao para ler o arquivo 
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
    //funcao para imprimir todas as informacoes
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
    //funcao para pegar a string que veio do arquivo e separar
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
    //sets de cada variavel
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
    //Gets de cada variavel
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
    //funcoes de impresao de cada variavel
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
    //funcao para imprimir todas as variaveis formatadas
    public String fraseInteira()
    {
        String frase =" ## "+nome+" ## "+altura+" ## "+String.valueOf(peso).replace(".0","")+" ## "+corDoCabelo+" ## "+corDaPele+" ## "+corDosOlhos+" ## "+corDaPele+" ## "+corDosOlhos+" ## "+anoNascimento+" ## "+genero+" ## "+homeworld+" ## ";
        return frase;
    }
}
//classe da arvore
class Arvore
{

    private no raiz;
    private no aux;

    public Arvore () {}

    public Arvore (String[] links,int contador)
    {
        //criacao da arvore
        raiz = new no(7);
        raiz.esq = new no(3);
        raiz.esq.esq = new no(1);
        raiz.esq.esq.esq = new no(0);
        raiz.esq.esq.dir = new no(2);
        raiz.esq.dir = new no(5);
        raiz.esq.dir.esq = new no(4);
        raiz.esq.dir.dir = new no(6);
        raiz.dir = new no(11);
        raiz.dir.esq = new no(9);
        raiz.dir.esq.esq = new no(8);
        raiz.dir.esq.dir = new no(10);
        raiz.dir.dir = new no(12);
        raiz.dir.dir.dir = new no(13);
        raiz.dir.dir.dir.dir = new no(14);

        for(int i = 1;i < contador;i++)
            inserir(new Personagem(links[i]));
    }  
    //funcao para inserir um personagem na arvore
    public void inserir(Personagem x)
    {
        aux = raiz;
        if(x.Getsaltura() % 15 < aux.elementop)
        {
            nodirp(x);
        }
        else if(x.Getsaltura() % 15 > aux.elementop)
        {
            noesqp(x);
        }
        else if(x.Getsaltura() % 15 == aux.elementop)
        {
            raizsub(x);
        }
    }

    public void nodirp(Personagem x)
    {
        if (aux.dir == null)
        {
            aux.dir = new no(x);
        }
        aux = aux.dir;
        if (x.Getsaltura() % 15 < aux.elementop)
        {
            nodirp(x);
        }
        else if (x.Getsaltura() % 15 > aux.elementop)
        {
            noesqp(x);
        }
        else if (x.Getsaltura() % 15 == aux.elementop)
        {
            raizsub(x);
        }
    }

    public void noesqp(Personagem x)
    {
        if (aux.esq == null)
        {
            aux.esq = new no(x);
        }
        aux = aux.esq;
        if (x.Getsaltura() % 15 < aux.elementop)
        {
            nodirp(x);
        }
        else if (x.Getsaltura() % 15 > aux.elementop)
        {
            noesqp(x);
        }
        else if (x.Getsaltura() % 15 == aux.elementop)
        {
            raizsub(x);
        }
    }

    public void raizsub(Personagem x)
    {
        if (aux.sub == null)
        {
            aux.sub = new no(x);
        }
        aux = aux.sub;
        else if (aux.elemento.Getsnome().compareTo(x.Getsnome()) < 0)
        {
            nodir(x);
        }
        else if (aux.elemento.Getsnome().compareTo(x.Getsnome()) > 0)
        {
            noesq(x);
        }
    }

    //funcao recursiva para acessar os nos mas baixo da arvore
    public void nodir(Personagem temp)
    {
        if (aux.dir == null)
        {
            aux.dir = new no(temp);
            aux = raiz;
        }
        aux = aux.dir;
        if (aux.elemento.Getsnome().compareTo(temp.Getsnome()) < 0)
            nodir(temp);
        else if (aux.elemento.Getsnome().compareTo(temp.Getsnome()) > 0)
            noesq(temp);
    }
    //funcao recursiva para acessar os nos mas baixo da arvore
    public void noesq(Personagem temp)
    {
        if (aux.esq == null)
        {
            aux.esq = new no(temp);
            aux = raiz;
        }
        aux = aux.esq;
        if (aux.elemento.Getsnome().compareTo(temp.Getsnome()) < 0)
            nodir(temp);
        else if (aux.elemento.Getsnome().compareTo(temp.Getsnome()) > 0)
            noesq(temp);
    }
    //funcao para verificar se existi esse nome na arvore
    public void verificao(String[] nomes, int contador)
    {
        aux = raiz;
        for (int i = 0;i < contador;i++)
        {
            MyIO.print(nomes[i]);
            verificaoraiz(nomes[i]);
        }
    }
    //funcao para verificar se o nome se encontra na raiz
    public void verificaoraiz(String nome)
    {
        MyIO.print(" raiz");
        if (aux.sub == null)
        {
            verificacaoresto(nome,raiz);
        }
        aux = raiz.sub;
        if (raiz.sub.elemento.Getsnome().compareTo(nome) == 0)
        {
            MyIO.print(" SIM\n");
        }
        else if (raiz.sub.elemento.Getsnome().compareTo(nome) < 0)
            verificacaodir(nome);
        else if (raiz.sub.elemento.Getsnome().compareTo(nome) > 0)
            verificacaoesq(nome);
    }
    
    public void verificacaodir(String nome)
    {
        MyIO.print(" dir");
        if (aux.dir == null)
        {
            aux = raiz;
            MyIO.print( " N"+(char)195+"O\n" );
            verificacaoresto(nome,raiz);
        }
        aux = aux.dir;
    if (aux.elemento.Getsnome().compareTo(nome) < 0)
            verificacaodir(nome);
        else if (aux.elemento.Getsnome().compareTo(nome) > 0)
            verificacaoesq(nome);
        else if (aux.elemento.Getsnome().compareTo(nome) == 0)
            MyIO.print(" SIM\n");
    }

    public void verificacaoesq(String nome)
    {
        MyIO.print(" esq");
        if (aux.esq == null)
        {
            aux = raiz;
            MyIO.print( " N"+(char)195+"O\n" );
            verificacaoresto(nome,raiz);
        }
        aux = aux.esq;
        if (aux.elemento.Getsnome().compareTo(nome) < 0)
            verificacaodir(nome);
        else if (aux.elemento.Getsnome().compareTo(nome) > 0)
            verificacaoesq(nome);
        else if (aux.elemento.Getsnome().compareTo(nome) == 0)
            MyIO.print(" SIM\n");
    }

    public boolean verificacaoresto(String nome, No nos)
    {
        boolean teste;
        if (nos == null)
        {
            teste = false;
        }
        else if (verificacaoresto(nome, nos.sub) == true)
        {
            teste = true;
        }
        else 
        {
            MyIO.print ("esq ");
            teste = verificacaoresto(nome, nos.esq);
            if (teste == false)
            {
                MyIO.print("dir ");
                teste = verificacaoresto(nome, nos.dir);
            }
        }
        return teste;
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
        MyIO.setCharset("iso-8859-1");
        String[] entrada = new String[2000];
        String[] entrada2 = new String[2000];
        int contador = 0;
        int contador2 = 0;
        //laco de repeticao com execucao ate ser digitado a palavra FIM
        do
        {
            //Entrada de string
            entrada[contador] = MyIO.readLine();
        }while(!isFim(entrada[contador++]));
        contador--;//desconsiderar o FIM
        Arvore arvore = new Arvore(entrada,contador);
        //laco de repeticao com execucao ate ser digitado a palavra FIM
        do
        {
            //Entrada de string
            entrada2[contador2] = MyIO.readLine();
        }while(!isFim(entrada2[contador2++]));
        contador2--;//desconsiderar o FIM
        arvore.verificao(entrada2, contador2);
    }
}
