public class Exercicio2
{
    int n = 10;
    //como o vetor se auto preenche com 0, vamos usar 0 como flag
    int[] deque = new int[n];

    public void InserirDir()
    {
        int cont = 0;
        for (int i = 0;i>n;i++)
        {
            if(deque[i] == 0)
                cont++;
        }
        if(cont == 0)
            printf("Operacao invalida, array cheio");
        else
        {
            for(int i = 1;i < n;i++)
            {
                int temp = deque[i-1];
                deque[i-1] = deque[i];
                deque[i] = temp;
            }
            deque[n-1] = MyIO.readLine();
        }
    }

    public void InserirEsq()
    {
        int cont = 0;
        for (int i = 0;i>n;i++)
        {
            if(deque[i] == 0)
                cont++;
        }
        if(cont == 0)
            printf("Operacao invalida, array cheio");
        else
        {
            for(int i=n-1;i>=0;i--)
            {
                int temp = deque[i-1];
                deque[i-1] = deque[i];
                deque[i] = temp;
            }
            deque[0] = MyIO.readLine();
        }
    }

    public void RemoverDir()
    { 
        int cont = 0;
        for (int i = 0;i>n;i++)
        {
            if(deque[i] == 0)
                cont++;
        }
        if(cont == n)
            MyIO.println("Operacao invalida, array vazio")
        else
        {
            int i = n-1;
            int j = n-1;
            do
            {
                if (deque[j] == 0)
                    j--;
                else
                    i = j;
            }while(i == n-1);
            deque[i] = 0;
        }
    }

    public void RemoverEsq()
    {
        int cont = 0;
        for (int i = 0;i>n;i++)
        {
            if(deque[i] == 0)
                cont++;
        }
        if(cont == n)
            MyIO.println("Operacao invalida, array vazio")
        else
        {
            int i = 0;
            int j = 0;
            do
            {
                if (deque[j] == 0)
                    j++;
                else
                    i = j;
            }while(i == n-1);
            deque[i] = 0;
        }
    }

    public static void main(String [] args)
    {
    }
}