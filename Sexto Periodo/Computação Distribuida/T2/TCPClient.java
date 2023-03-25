import java.net.*;
import java.util.Scanner;
import java.io.*;
public class TCPClient {
	public static void main (String args[]) {
		// arguments supply message and hostname
        System.out.println("TCP Client");
		Socket s = null;
		try{
			int serverPort = 7896;
			s = new Socket("192.168.0.103", serverPort);    
			DataInputStream in =  new DataInputStream( s.getInputStream());
			DataOutputStream out = new DataOutputStream( s.getOutputStream());
            Scanner scan = new Scanner(System.in);
            while(true) {
                System.out.print("Escreva a mensagem: ");
                String message = scan.nextLine();
                out.writeUTF(message);  
                System.out.println("Send Message:"+message);    	// UTF is a string encoding see Sn. 4.4
                String data = in.readUTF();	    // read a line of data from the stream
                System.out.println("Received: "+ data); 
            }
		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }
}