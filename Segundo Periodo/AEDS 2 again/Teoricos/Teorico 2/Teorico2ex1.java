public class Teorico2ex1
{

    //testes para checar a funcao
    /*public static void main(String [] args)
    {
        int vetor[] = new int[5];
        vetor[2] = 2;
        boolean teste = Checar(vetor, 3);
        if (teste)
            System.out.println("verdade");
    }*/

    public static boolean Checar(int vetor[],int x)
    {
        boolean retorno = false;
        for (int i = 0;i < vetor.length;i++)
        {
            if (vetor[i] == x)
                retorno = true;
        }
        return retorno;
    }
}