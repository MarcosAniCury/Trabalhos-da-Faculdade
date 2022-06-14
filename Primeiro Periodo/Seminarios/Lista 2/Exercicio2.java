import java.util.Scanner;

public class Exercicio2
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int nu1[], nu2[];
        nu1 = new int[N];
        nu2 = new int[N];
        boolean teste;
        for (int cont = 0;cont < N;cont++)
        {
            teste = true;
            nu1[cont] = scan.nextInt();
            nu2[cont] = scan.nextInt();
            if (nu1[cont] % 2 == 0 && nu2[cont] % 2 == 0)
                teste = false;
            else if (nu1[cont] % 3 == 0 && nu2[cont] % 3 == 0)
                teste = false;
            else if (nu1[cont] % 5 == 0 && nu2[cont] % 5 == 0)
                teste = false;
            else if (nu1[cont] % 7 == 0 && nu2[cont] % 7 == 0)
                teste = false;
            if (teste)
                System.out.println("SIM");
            else
                System.out.println("NAO");
        }
	}
}
