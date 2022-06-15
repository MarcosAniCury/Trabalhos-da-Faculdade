import java.util.Scanner;

public class Maiuscula 
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        String palavra = "0";
        int cont;
        while (palavra != "FIM")
        {
            cont = 0;
            palavra = scan.nextLine();
            char[] palavraArray = palavra.toCharArray();
            if (palavraArray[0] == 'F' && palavraArray[1] == 'I' && palavraArray[2] == 'M')
                palavra = "FIM";
            if (palavra != "FIM")
            {
                for(char c : palavraArray)
                {
                    if(Character.isUpperCase(c))
                        cont++;
                }
                System.out.println(cont);
            }
        }
    }
}