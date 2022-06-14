import java.util.Scanner;

class Alunos
{
    int N;
    String frase;
    String nome;
    int NS[] = new int[6];
    int problemas = 0;
    int tempo;
    public Alunos(String frase,int N)
    {
        this.N = N;
        this.frase = frase;
        FraseDividida();
        ProblemasResol();
    }
    void FraseDividida()
    {
        String[] FraseSplit = frase.split(";");
        nome = FraseSplit[0];
        for (int cont = 0;cont < 6;cont++)
            NS[cont] = Integer.parseInt(FraseSplit[cont + 1]);
    }
    void ProblemasResol()
    {
        for (int cont = 0;cont < 6;cont++)
        {
            if (NS[cont] != 0)
                problemas++;
            tempo = tempo + NS[cont];
        }
    }
}

public class Exercicio10
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        int N;
        boolean teste;
        do
        {
            N = scan.nextInt();
            teste = N < 1 || N > 30;
        }while(teste);
        Alunos TotalAlunos[] = new Alunos[N];
        for (int cont = 0;cont < N;cont++)
        {
            String frase = scan.next();
            TotalAlunos[cont] = new Alunos(frase,N);
        }
        int problemasr = 0;
        for (int cont = 0;cont < N;cont++)
        {
            int aux = TotalAlunos[cont].problemas;
            if (cont == 0)
                problemasr = aux;
            if (problemasr < aux)
                problemasr = aux;
        }
        int Aux[] = new int[N];
        int conta = 0;
        for (int cont = 0;cont < N;cont++)
        {
            int aux = TotalAlunos[cont].problemas;
            int aux2 = TotalAlunos[cont].tempo;
            if (problemasr == aux)
            {
                Aux[conta] = aux2;
                conta++;
            }
        }
        int MTempo = 0;
        for (int cont = 0;cont < conta;cont++)
        {
            if (cont == 0)
                MTempo = Aux[cont];
            if(MTempo > Aux[cont])
                MTempo = Aux[cont];
        }
        String nomes = "a";
        for (int cont = 0;cont < N;cont++)
        {
            int aux = TotalAlunos[cont].problemas;
            int aux2 = TotalAlunos[cont].tempo;
            if(aux == problemasr || aux2 == MTempo)
                nomes = TotalAlunos[cont].nome;
        }
        System.out.println(nomes);
        System.out.println(problemasr+" PROBLEMAS");
        System.out.println(MTempo+" MINUTOS");
    }
}