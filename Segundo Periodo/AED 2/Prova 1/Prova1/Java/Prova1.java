import java.lang.String;
import java.lang.Object;

class Aluno 
{
    private static String Nome;
    private static String Assinatura;

    public Aluno(){}

    public static void Setnome(String nome)
    {
        Nome = nome;
    }
    public static void Setassinatura(String assinatura)
    {
        Assinatura = assinatura;
    }
    public static String Getnome()
    {
        return Nome;
    }
    public static String Getassinatura()
    {
        return Assinatura;
    }
}

class Lista 
{

    private static Aluno[] aluno;
    private static Aluno[] alunospresentes;
    private static int nalunos;
    private static int nalunospresentes;

    public Lista () {}

    public Lista (int contador)
    {
        nalunos = contador;
        aluno = new Aluno[contador];
        for (int i = 0;i < contador; i++)
        {
            aluno[i].Setnome(MyIO.readString());
            aluno[i].Setassinatura(MyIO.readString());
        }
    }

    static void AlunosPresente(int m)
    {
        nalunospresentes = m;
        alunospresentes = new Aluno[m];
        for(int i = 0;i < m;i++)
        {
            alunospresentes[i].Setnome(MyIO.readString());
            alunospresentes[i].Setassinatura(MyIO.readString());
        }
    }
    
    static void ComparacaodeAlunos()
    {
        int contador = 0;
        for(int i = 0;i < nalunospresentes;i++)
        {
            for(int j = 0;j < nalunos;j++)
            {
                if(aluno[j].Getnome().compareTo(alunospresentes[i].Getnome()) == 0)
                {
                    if(aluno[j].Getassinatura().compareTo(alunospresentes[i].Getassinatura()) != 0)
                    {
                        contador++;
                    }
                    j = nalunos;
                }
            }
        }
        MyIO.println(contador);
    }
}
public class Prova1
{
    public static void main(String []args)
    {
        MyIO.setCharset("UTF-8");
        int n = MyIO.readInt();
        while (n != 0)
        {
            Lista aluno = new Lista(n);
            int m = MyIO.readInt();
            aluno.AlunosPresente(m);
            aluno.ComparacaodeAlunos();
            n = MyIO.readInt();
        }
    }
}