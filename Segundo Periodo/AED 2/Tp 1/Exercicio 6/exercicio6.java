import java.lang.String;
import java.io.*;

public class exercicio6
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }
    public static boolean Consoante(char letra)
    {
        boolean resposta = false;
        if(letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u')
            resposta = true;
        return resposta;
    }
    public static boolean Vogal(char letra)
    {
        boolean resposta = false;
        if (letra == 'a' && letra == 'e' && letra == 'i' && letra == 'o' && letra == 'u')
            resposta = true;
        return resposta;
    }
    public static boolean Inteiro(char letra)
    {
        boolean resposta = false;
        if(letra < 'a' && letra > 'z')
            resposta = true;
        return resposta;
    }
    public static void Resposta(boolean resposta)
    {
        if(resposta)
            MyIO.print("SIM ");
        else
            MyIO.print("NAO ");
    }
    public static void Verificacao(String palavra)
    {
        boolean pontoflu = true;
        boolean inteiro = true;
        boolean consoante = true;
        boolean vogal = true;
        //laco para verificar letra por letra
        for (int i = 0;i < palavra.length();i++)
        {
            if(pontoflu)
                pontoflu = Inteiro(palavra.charAt(i));
            if(inteiro)
                inteiro = Inteiro(palavra.charAt(i));
            if (vogal)
                vogal = Vogal(palavra.charAt(i));
            if (consoante)
                consoante = Consoante(palavra.charAt(i));
        }
        //verificar se o float tambem e int
        if(inteiro)
        {
            inteiro = (palavra.matches("(.*).0(.*)") || palavra.matches("(.*).00(.*)"));
        } 
        Resposta(vogal);
        Resposta(consoante);
        Resposta(inteiro);
        Resposta(pontoflu);
        MyIO.println("");
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
        //laco para passar por todas as strings
        for(int i = 0; i < contador;i++)
        {
            Verificacao(entrada[i]);
        }
    }
}
