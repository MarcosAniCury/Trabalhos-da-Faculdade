public class exercicio12
{
    public static String palavratroca(String palavra)
    {
        return trocapalavra(palavra, 0);
    }
    public static String trocapalavra(String palavra, int i)
    {
        if (i != palavra.length())
        {
            String palavra1 = "";
            palavra1 += troca(palavra.charAt(i));
            if (i + 1 != palavra.length())
            {
                for(int j = i + 1;j < palavra.length();j++)
                    palavra1 += palavra.charAt(j);
            }
            palavra = trocapalavra(palavra1, ++i);
        }
        return palavra;
    }
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    //funcao para alterar a letra por uma com um valor maior em 3, e printar a mesma
    public static char troca(char letra)
    {
        int numero = (int) letra + 3;
        letra = (char) numero;
        return letra;
    }
    public static void main(String [] args)
    {
        String[] entrada = new String[2000];
        int contador = 0;
        //laco de repeticao com execucao ate ser digitado a palavra FIM
        do
        {
            //Entrada de string
            entrada[contador] = MyIO.readLine();
        }while(!isFim(entrada[contador++]));
        contador--;//desconsiderar o FIM
        //laco de repeticao para utilizar todas as strings
        for(int i = 0;i <= contador;i++)
        {
            MyIO.println(palavratroca(entrada[i]));
        }
    }
}