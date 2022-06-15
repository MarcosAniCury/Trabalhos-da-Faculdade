import java.util.Random;

public class exercicio4
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    //funcao para printar as string com as letras trocadas
    public static void troca(char letra, char letra0, char letra1)
    {
        if (letra == letra0)
            MyIO.print(letra1);
        MyIO.print(letra);
    }
    public static void main(String [] args)
    {
        Random gerador = new Random();
        gerador.setSeed(4);
        String[] entrada = new String[2000];
        int contador = 0;
        //laco de repeticao com execucao ate ser digitado a palavra FIM
        do
        {
            //Entrada de string
            entrada[contador] = MyIO.readLine();
        }while(!isFim(entrada[contador++]));
        contador--;//desconsiderar o FIM
        //laco de repeticao para gerar 2 letras "aleatorias" e pegar cada letra de cada string e levar para a funcao de troca
        for(int i = 0;i <= contador;i++)
        {
            int numero0 = (int) 'a' + gerador.nextInt() % 26;
            char letra0 = (char) numero0;
            int numero1 = (int) 'a' + gerador.nextInt() % 26;
            char letra1 = (char) numero1;
            for (int j = 0;j < entrada[i].length();j++)
            {
                troca(entrada[i].charAt(j),letra0,letra1);
            }
            MyIO.println("");
        }
    }
}