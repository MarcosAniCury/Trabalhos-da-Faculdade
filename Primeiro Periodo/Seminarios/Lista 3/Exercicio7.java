import java.util.Scanner;

public class Exercicio7
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int saldo = scan.nextInt();
        int menorsaldo = saldo;
        int Nu[] = new int[N];
        for (int cont = 0;cont < N;cont++)
        {
            Nu[cont] = scan.nextInt();
            saldo = saldo + Nu[cont];
            if (saldo < menorsaldo)
                menorsaldo = saldo;
        }
        System.out.println(menorsaldo);
    }
}