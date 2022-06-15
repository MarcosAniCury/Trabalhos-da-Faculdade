
import java.util.Scanner;

public class Exercicio6
{
    public static void main (String [] arg)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int A[] = new int[N - 1];
        int Faltando = 0;
        int cont3 = 1,cont,cont2;
        for (cont = 0;cont < N - 1;cont++)
        {
            A[cont] = scan.nextInt();
        }
        for (cont = 1;cont < N + 1;cont++)
        {
            if (cont3 != cont)
            {
                Faltando = cont - 1;
                System.out.println(Faltando);
                break;
            }
            for (cont2 = 0;cont2 < N - 1;cont2++)
            {
                if (A[cont2] == cont)
                {
                    cont3++;
                }
            }
        }
        if (cont == cont3)
            Faltando = N;
    }
}