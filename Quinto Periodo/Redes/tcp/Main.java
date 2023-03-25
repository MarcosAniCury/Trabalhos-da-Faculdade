import java.io.*;
import java.net.*;
import java.util.*;


class Main {
   private static int portaServidor = 6789;

   public static void printDadosServidor(ServerSocket socket){
      InetAddress	inetAddress = socket.getInetAddress();
      String ipServidor = inetAddress.getHostAddress();
      String hostName = inetAddress.getHostName();
      System.out.println("IP Servidor: " + ipServidor);
      System.out.println("Host Name: " + hostName);
      System.out.println("Porta Servidor: " + socket.getLocalPort());

      try {
         System.out.println("Full list of Network Interfaces:");
         for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
            NetworkInterface intf = en.nextElement();
            System.out.println("    " + intf.getName() + " " + intf.getDisplayName());
            for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
               System.out.println("        " + enumIpAddr.nextElement().toString());
            }
         }
      } catch (SocketException e) {
         System.out.println(" (error retrieving network interface list)");
      }
   }

   public static void main(String argv[]) throws Exception {
      //Efetua as primitivas socket, bind e listen
      ServerSocket socket = new ServerSocket(portaServidor);

      printDadosServidor(socket);

      while(true) {

         //Efetua a primitiva accept
         System.out.println("Aguardando conexão...");
         Socket conexao = socket.accept();

         System.out.println("Conexão efetuada com Cliente (IP " + conexao.getInetAddress().getHostAddress() + " e porta " + conexao.getPort() + ")");
         System.out.println("Conexão meu IP (" + conexao.getLocalAddress().getHostAddress() + ") e porta (" + conexao.getLocalPort() + ")");

         //Efetua a primitiva receive
         System.out.println("Aguardando datagrama do cliente...");
         BufferedReader entrada =  new BufferedReader(new InputStreamReader(conexao.getInputStream()));

         //Operacao com os dados recebidos e preparacao dos a serem enviados
         String str = entrada.readLine();
         System.out.println("Received: " + str);

         str = str.toUpperCase() + '\n';

         //Efetua a primitiva send
         DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
         saida.writeBytes(str);

         //Efetua a primitiva close
         conexao.close();
      }
   }
}
