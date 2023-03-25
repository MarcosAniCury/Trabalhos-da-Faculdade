import java.net.*;
import java.util.Scanner;
import java.io.*;
public class UDPClient{
    public static void main(String args[]){ 
		// args give message contents and destination hostname
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();    
            aSocket.setSoTimeout(1000);
			InetAddress aHost = InetAddress.getByName("192.168.0.103");
			int serverPort = 6789;
            Scanner scan = new Scanner(System.in);
            while(true) {
                System.out.print("Digite sua mensagem: ");
                String message = scan.nextLine();
                byte [] m = message.getBytes();
                DatagramPacket request =
                    new DatagramPacket(m,  message.length(), aHost, serverPort);
                aSocket.send(request);		

                byte[] buffer = new byte[1000];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
                aSocket.receive(reply);
                System.out.println("Reply: " + new String(reply.getData()));	
            }
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	
}