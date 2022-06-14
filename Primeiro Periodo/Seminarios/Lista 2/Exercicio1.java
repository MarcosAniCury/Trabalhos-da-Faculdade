import java.util.Scanner;

public class Exercicio1
{
	public static void main(String [] args)
	{
		boolean teste = true;
		Scanner scan = new Scanner(System.in);
		int N = 100,cont3 = 0;
		while (teste) //while para q so possa digitar valores validos.
		{
			//System.out.printf("\n Digite um valor entre 2 e 100:");
			N = scan.nextInt();
			teste = N < 2 || N > 100;
			//if (teste)
			//	System.out.printf("\n Valor ínvalido, digite novamente.");
		}
		int M[]; //objeto array.
        M = new int[N];//tamanho definido.
        for (int cont = 0;cont < M.length;cont++)
        {
                //System.out.printf("\n Digite um valor entre 1 e 100:");
			    M[cont] = scan.nextInt(); 
        }
        for (int cont1 = 0;cont1 < N;cont1++)
        {
                int Num = M[cont1];
                if (Num != -1)
                    for (int cont2 = cont1 + 1;cont2 < N;cont2++)
                    {
                        if (M[cont2] == Num)
                        {
                            cont3++;
                            cont2 = N - 1;
                        }
                    }
                    for (int cont4 = 0;cont4 < N;cont4++)
                    {
                        if (M[cont4] == Num)
                            M[cont4] = -1;
                    }
        }
        System.out.println(cont3);
	}
}
