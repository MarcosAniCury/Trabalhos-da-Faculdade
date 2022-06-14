public class exercicio3
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    //funcao para alterar a letra por uma com um valor maior em 3, e printar a mesma
    public static void troca(char letra)
    {
        int numero = (int) letra + 3;
        letra = (char) numero;
        MyIO.print(letra);
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
            //laco de repeticao para enviar uma letra de cada vez da string
            for(int j = 0;j < entrada[i].length();j++)
            {
                troca(entrada[i].charAt(j));
            }
            MyIO.println("");
        }
    }
}