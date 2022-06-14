import java.io.*;

public class InterfaceUla
{
    static final String nomeArqEntrada = "testeula.ula";
    static final String nomeArqSaida = "testeula.hex";

    public static boolean isAtribuicao(String arg)
    {
        boolean retorno = false;
        if (arg.charAt(1) == '=')
            retorno = true;
        return retorno;
    }

    public static String operacao(String op)
    {
        String retorno = "";
        if (op.equals("an"))
            retorno = "0";
        else if(op.equals("naob"))
            retorno = "1";
        else if(op.equals("anb"))
            retorno = "2";
        else if(op.equals("zerol"))
            retorno = "3";
        else if(op.equals("naeb"))
            retorno = "4";
        else if(op.equals("bn"))
            retorno = "5";
        else if(op.equals("axb"))
            retorno = "6";
        else if(op.equals("abn"))
            retorno = "7";
        else if(op.equals("anob"))
            retorno = "8";
        else if(op.equals("naxb"))
            retorno = "9";
        else if(op.equals("b"))
            retorno = "A";
        else if(op.equals("ab"))
            retorno = "B";
        else if(op.equals("uml"))
            retorno = "C";
        else if(op.equals("aobn"))
            retorno = "D";
        else if(op.equals("aob"))
            retorno = "E";
        else if(op.equals("a"))
            retorno = "F";
        return retorno;
    }

    public static void main(String [] args)
    {
        String x = "";
        String y = "";
        String op = "";
        try
        {
            File arq = new File(nomeArqSaida); //Objeto arq saida
            arq.createNewFile(); //Criando novo Arquivo
            FileWriter arqSaida = new FileWriter(arq);  //Criando Objeto de escrita
            BufferedWriter warqSaida = new BufferedWriter(arqSaida);    //Criando Buffer de escrita
            FileReader fr = new FileReader(nomeArqEntrada);   //Abertura do arquivo         
            BufferedReader br = new BufferedReader(fr);   //Leitura em Buffer
            String temp = br.readLine().toLowerCase();
            while(!temp.equals("fim."))
            {
                if (!temp.equals("inicio:"))
                {
                    int tamTemp = temp.length();
                    if (isAtribuicao(temp))
                    {
                        if (temp.charAt(0) == 'x')
                            x = temp.substring(2,tamTemp-1).toUpperCase();
                        else
                            y = temp.substring(2,tamTemp-1).toUpperCase();
                    }
                    else
                    {
                        op = operacao(temp.substring(0, tamTemp-1));
                        String saidaArq = x+y+op;
                        warqSaida.write(saidaArq);
                    }
                }
                temp = br.readLine().toLowerCase();
            }
            warqSaida.newLine();
            br.close();    //Fechando Buffer
            fr.close();    //Fechando arquivo
            warqSaida.close();
            arqSaida.close();
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
        }
    }
}