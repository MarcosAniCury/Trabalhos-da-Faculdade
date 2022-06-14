import java.util.Scanner;

public class Exercicio4
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int A[] = new int[N];
        for (int cont = 0;cont < N;cont++)
            A[cont] = scan.nextInt();
        int T = scan.nextInt();
        int Tes[] = new int[T];
        int Tes2[] = new int[T];
        boolean teste;
        for (int cont = 0;cont < T;cont++)
        {
            Tes[cont] = scan.nextInt();
            Tes2[cont] = scan.nextInt();
        }
        for (int cont = 0;cont < T;cont++)
        {
            teste = true;
            for (int cont2 = Tes[cont];cont2 < Tes2[cont];cont2++)
            {
                if (A[cont2] > A[cont2 + 1])
                    teste = false;
            }
            if (teste)
                System.out.println("SIM");
            else    
                System.out.println("NAO");
        }
    }
}