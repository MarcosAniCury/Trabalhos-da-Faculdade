import java.util.Scanner;
import java.util.Arrays;

public class Exercicios3
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int A[][] = new int[N][N];
        int Lin = scan.nextInt();
        int Col = scan.nextInt();
        A[Lin - 1][Col - 1] = 1;
        int Lin1 = scan.nextInt();
        int Col1 = scan.nextInt();
        A[Lin1 - 1][Col1 - 1] = 1;
        boolean Corte = true;
        int metade = (N / 2) - 1;
        int cont2 = 0;
        for (int cont = 0; cont < N;cont++)
        {
            if (A[metade][cont] == 1)
                cont2++;
            if (cont2 == 2)
                Corte = false;
            cont2 = 0;
            if (A[metade + 1][cont] == 1)
                cont2++;
            if (cont2 == 2)
                Corte = false;
            cont2 = 0;
            if (A[cont][metade] == 1)
                cont2++;
            if (cont2 == 2)
                Corte = false;
            cont2 = 0;
            if (A[cont][metade + 1] == 1)
                cont2++;
            if (cont2 == 2)
                Corte = false;
        }
        if (Corte)
            System.out.printf("S");
        else    
            System.out.printf("N");
    }
}