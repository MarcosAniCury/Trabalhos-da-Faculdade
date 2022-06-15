import java.util.Scanner;

class ClasseTes
{
    int idade;
    String nome;
    public ClasseTes(int N,String nome)
    {
        this.nome = nome;
        this.idade = N;
    }
    public void teste()
    {
        if(idade == 6)
            idade = 12;
    }
} 

public class TreinoClasse
{
    public static void main(String [] args)
    {
        int N = 6;
        String nome = "Marcos";
        ClasseTes EnviodeDados = new ClasseTes(N, nome);
        EnviodeDados.teste();
    }
}