import java.util.Scanner;

class Acertos
{
    int N;
    String frase;
    String nome;
    public Acertos(String frasere, int N)
    {
        this.frase = frasere;
        this.N = N;
    }
}




public class Exercicio9
{
    
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int N;
        do
        {
            N = scan.nextInt();
        }while(N < 1 || N > 30);
        String frase = scan.next();
        Acertos resultado = new Acertos(frase, N);
    }
}