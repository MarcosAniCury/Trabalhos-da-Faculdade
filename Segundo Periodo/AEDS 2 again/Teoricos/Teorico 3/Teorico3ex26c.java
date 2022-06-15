public class Teorico3ex26c
{
    public static void main (String [] args)
    {
        int n = MyIO.readLine();
        int a = 1000;

        for (int i = n; i > 0; i = i/2)
        {
            a--;
        }

        for(int i = 0; i < n;i++)
        {
            a--;
        }
    }
}