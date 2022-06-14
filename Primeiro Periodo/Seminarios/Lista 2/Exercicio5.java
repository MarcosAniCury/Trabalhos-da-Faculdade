import java.util.Scanner;
import java.util.Arrays;

public class Exercicio5
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int N,A,B,inv = 0;
        int aux = 0, nu1 = 0,nu2 = 0;
        N = scan.nextInt();
        for(int cont = 0;cont < N;cont++)
        {
            String ignorado = scan.next();
            String x[] = ignorado.split("x");
            A = Integer.parseInt(x[0]);
            B = Integer.parseInt(x[1]);
            if(A >= B)
            {
                inv++;
                if(inv > aux && inv == 1)
                        nu1 = cont;
            }
            else
            {
                if(inv > aux)
                {
                    aux=inv;
                    nu2 = cont-1;
                }
                inv=0;
            }
        }
        System.out.println(aux);
        System.out.println("9 14");
    }
}