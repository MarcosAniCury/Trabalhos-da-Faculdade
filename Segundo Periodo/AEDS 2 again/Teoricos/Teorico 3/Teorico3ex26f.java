public class Teorico3ex26f
{
    public static void main (String [] args)
    {
        int n = MyIO.readLine();
        int a = 10000;

        for (int i = n; i > 0; i = i/2)
        {
            a--;
        }

        for (int i = n; i > 0; i = i/2)
        {
            a= a-5;
        }
    }
}