public class Teo6Ex2
{
    public static void main(String []args)
    {
        int n = 15;
        int x = 1; 
        int[] array = new int[n];
        for (int i  = 14;i > 0;i--)
        {
            array[x] = i;
            x++;
        }
        for (int i = 1; i < n; i++) 
        {
            int tmp = array[i];       
            boolean resp = false;
            int dir = i - 1, esq = 0, meio = 0;
            while (esq <= dir) 
            {
                meio = (esq + dir) / 2;
                if ((tmp > array[meio] && tmp < array[meio + 1]) || tmp == array[meio])
                {
                    resp = true;
                    esq = n;
                } 
                else if (tmp > array[meio])
                    esq = meio + 1; 
                else 
                    dir = meio - 1;
            }
            for (int j = i - 1;j > meio;j--)
                array [j + 1] = array[j];
            array[meio + 1] = tmp;
        }
        for(int i = 0;i < n;i++)
            MyIO.println(array[i]);
    }
}