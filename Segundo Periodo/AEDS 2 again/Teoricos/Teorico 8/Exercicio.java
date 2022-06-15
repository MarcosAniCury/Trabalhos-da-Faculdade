public class Exercicio
{
    public static void MaiorMenor()
    {
        int[] array = new int[10];
        int n = 10,maior = 0,menor = 0;
        for (int i = 0;i < n;i++)
            array[i] = i;
        menor = maior = array[0];
        for (int i = 0; i < n;i++)
        {
            if (maior < array[i])
                maior = array[i];
            if (menor > array[i])
                menor = array[i];
        }
        MyIO.println("Maior:"+maior);
        MyIO.println("Menor:"+menor);
    }

    public static void main(String [] args)
    {   
        MaiorMenor();
    }
}