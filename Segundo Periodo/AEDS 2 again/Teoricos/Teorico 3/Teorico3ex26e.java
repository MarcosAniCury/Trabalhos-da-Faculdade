public class Teorico3ex26e
{
    public static void main (String [] args)
    {
        int n = MyIO.readLine();
        int a = 10000;

        for(int i = 0; i < n;i++)
        {
            for (int j = 0;j < n;j++)
            {
                for (int x = 0; x < n;x++)
                {
                    for (int z = 0; z < n;z++)
                    {
                        a = a - 9;
                    }
                }
            }
        }

        for(int i = 0; i < n;i++)
        {
            for (int j = 0;j < n;j++)
            {
                a = a - 5; 
            }
        }

        for (int i = 0; i < n/2;i++)
            a--;
    }
}