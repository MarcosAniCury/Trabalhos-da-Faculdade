public class exercicio10
{
    //funcao para retornar se e palindromo ou nao
    public static String palindromo(String palavra)
    {
        String retorno;
        int numero = palavra.length() - 1;
        if(ehpalindromo(palavra, numero , 0))
            retorno = "SIM";
        else
            retorno = "NAO";
        return retorno;
    }
    public static Boolean ehpalindromo(String palavra, int numero, int number)
    {
        boolean resposta = true;
        if(numero != number && numero >= (palavra.length()/2))
        {
            if (palavra.charAt(number) == palavra.charAt(numero))
            {
                if(number == numero - 1)
                    resposta = true;
                else
                    resposta = ehpalindromo(palavra, --numero, ++number);
            }
            else
                resposta = false;
        }
        return resposta;
    }
    //funcao que identifica se a palavra digitada foi FIM
    public static boolean isend (String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    public static void main(String[] args)
    {
        String[] entrada = new String[2000];
        int contador = 0;
        //Entrada de string
        do{//laco de repeticao com execucao ate ser digitado a palavra FIM
            entrada[contador] = MyIO.readLine();
        }while(!isend(entrada[contador++]));
        contador--;//desconsiderar o FIM
        for (int i = 0;i < contador;i++) //repeticao para analisar cada palavra
            MyIO.println(palindromo(entrada[i]));
    }
}
