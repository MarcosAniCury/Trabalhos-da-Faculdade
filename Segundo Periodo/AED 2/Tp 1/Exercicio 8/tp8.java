import java.text.*;
import java.io.*;
import java.util.*; 

public class tp8
{
    public static void main (String[]args)
    {
        try 
        {
            RandomAccessFile arq = new RandomAccessFile("texto.txt", "rw");
            int n = MyIO.readInt();
            for(int i = 0; i < n;i++)
            {
                arq.writeDouble(MyIO.readDouble());
            }
            NumberFormat format = NumberFormat.getNumberInstance(Locale.ENGLISH);
            format.setMinimumFractionDigits(0);
            arq.close();    
            RandomAccessFile arq1 = new RandomAccessFile("texto.txt", "r");
            long nulo = arq1.length() - 8;
            for(long i = nulo; i >= 0;i = i - 8)
            {
                arq1.seek(i);
                MyIO.println(format.format(arq1.readDouble()));
            }
            arq1.close();
        }
        catch (IOException ex) 
        {
             ex.printStackTrace();
        }    
    } 
}