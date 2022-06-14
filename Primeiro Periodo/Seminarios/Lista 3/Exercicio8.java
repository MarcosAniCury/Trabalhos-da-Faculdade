import java.util.Scanner;
import java.time.LocalDate;
import java.util.Arrays;

public class Exercicio8
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String datatorneio = scan.next();
        String[] datatorneiode = datatorneio.split("/");
        int diat = Integer.parseInt(datatorneiode[0]);
        int mest = Integer.parseInt(datatorneiode[1]);
        int anot = Integer.parseInt(datatorneiode[2]);
        anot = anot - 15;
        LocalDate datat = LocalDate.of(anot, mest, diat);
        String atletas;
        String atletasn[] = new String[N];
        LocalDate data[] = new LocalDate[N];
        LocalDate menor = datat; 
        for (int cont = 0;cont < N;cont++)
        {
            atletas = scan.next();
            String[] atletaux = atletas.split(";");
            atletasn[cont] = atletaux[0];
            String aux = atletaux[1];
            String[] atletaux2 = aux.split("/");
            int dia = Integer.parseInt(atletaux2[0]);
            int mes = Integer.parseInt(atletaux2[1]);
            int ano = Integer.parseInt(atletaux2[2]);
            data[cont] = LocalDate.of(ano, mes, dia);
            if (cont == 0)
                menor = data[cont];
            int comp = data[cont].compareTo(menor);
            if (comp >= 1)
                menor = data[cont];
            int compa = data[cont].compareTo(datat);
            if (compa >= 1)
                System.out.println(atletasn[cont]);
        }
        for(int cont = 0;cont < N;cont++)
        {
            int compa = data[cont].compareTo(menor);
            if (compa == 0)
                System.out.println("CAPITAO: "+atletasn[cont]);
        }
    }
}