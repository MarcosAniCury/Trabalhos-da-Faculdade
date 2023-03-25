import java.io.*;
import java.net.*;

class Cliente {
   private static int portaServidor = 6789;
   private static String ipServidor = "2804:14c:5b71:589e::1000";
//   private static String ipServidor = "::1";
//   private static String ipServidor = "192.168.0.92";

   public static String lerString () throws Exception {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      return in.readLine();
   }

   public static void main(String argv[]) throws Exception {
      //Efetua a primitiva conexao
      Socket conexao = new Socket(ipServidor, portaServidor);

      System.out.println("Conexão efetuada com Servidor (IP " + conexao.getInetAddress().getHostAddress() + " e porta " + conexao.getPort() + ")");
      System.out.println("Conexão meu IP (" + conexao.getLocalAddress().getHostAddress() + ") e porta (" + conexao.getLocalPort() + ")");

      //Efetua a primitiva send
      DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
      saida.writeBytes(lerString() + '\n');


      //Efetua a primitiva receive
      BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
      System.out.println("FROM SERVER: " + entrada.readLine());

      //Efetua a primitiva close
      conexao.close();
   }
}
