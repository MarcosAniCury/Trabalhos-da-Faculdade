public class Exercicio3
{
    int n = 10;
    int[] heapsort = new int[n];

    public static int maiorEsq()
    {
        int pont = 2;
        int menor = heapsort[2];
        do
        {
            if (heapsort[pont*2] < heapsort[pont*2 + 1])
            {
                pont = pont * 2;
                menor = heapsort[pont];
            }
            else if (!(pont * 2+1 >= n))
            {
                pont = pont * 2 + 1;
                menor = heapsort[pont]; 
            }
        }while(pont * 2 >= n);
        return menor;
    }
}