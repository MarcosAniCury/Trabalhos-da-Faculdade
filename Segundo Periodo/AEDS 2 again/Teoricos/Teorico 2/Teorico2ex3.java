public class Teorico2ex3
{

    //testes para checar a funcao
    /*public static void main(String [] args)
    {
        int vetor[] = {0,1,2,3,4,5,6,7,8,9};
        MaiorMenor(vetor);
    }*/

    public static void MaiorMenor(int vetor[])
    {
        int maior = vetor[0];
        int menor = vetor[0];
        for (int i = 1;i < vetor.length;i++)
        {
            if (maior < vetor[i])
                maior = vetor[i];
            if (menor > vetor[i])
                menor = vetor[i];
        }
        MyIO.println("Maior = "+maior+",Menor = "+menor);
    }
}