public class Teorico2ex2
{

    //testes para checar a funcao
    /*public static void main(String [] args)
    {
        int vetor[] = {0,1,2,3,4,5,6,7,8,9};
        boolean teste = Checar(vetor, 10);
        if (teste)
            System.out.println("verdade");
    }*/

    public static boolean Checar(int vetor[],int x)
    {
        boolean retorno = false;
        if (x < vetor[vetor.length / 2])
        {
            for (int i = 0;i < vetor.length/2;i++)
            {
                if (vetor[i] == x)
                    retorno = true;
            }
        }
        else
        {
            for (int i = vetor.length/2; i < vetor.length;i++)
            {
                if (vetor[i] == x)
                    retorno = true;
            }
        }
        return retorno;
    }
}