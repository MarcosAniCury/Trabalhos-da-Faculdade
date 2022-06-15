public class Teorico3ex26b
{
    public static void main (String [] args)
    {
        int n = MyIO.readLine();
        int a = 1000;

        for (int i = 0; i < n;i++)
        {
            a--;
            a--;
            a--;
            a--;
            a--;
        }

        for(int i = 0; i < n;i++)
        {
            for (int j = 0;j < n;j++)
            {
                for (int x = 0; x < n;x++)
                {
                    a--;
                    a--;
                    a--;
                    a--;
                }
            }
        }
    }
}