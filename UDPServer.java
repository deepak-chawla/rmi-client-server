import java.io.*;
import java.net.*;
import java.util.*;

public class UDPServer {
public static void main(String[] args) throws Exception {
 
byte[] buffer = new byte[256];  					   

 System.out.println("Opening port 1234...\n");
 String message = "";
 DatagramSocket datagramSocket =    new DatagramSocket(1234); 
 Scanner cmdinput = new Scanner(System.in);   
 String msg1 = "";
 
 while(!message.equalsIgnoreCase("CLOSE")){	       
 
 DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length); 
 
 datagramSocket.receive(inPacket);						   
 
 InetAddress clientAddress = inPacket.getAddress(); 			   
 
 int clientPort =  inPacket.getPort(); 				         

 message = new String(inPacket.getData(),0,inPacket.getLength()); 

 System.out.println("Client says: " + message); 
 
 System.out.print("Enter reply to Client: ");

 msg1 = cmdinput.next();	                    

 DatagramPacket outPacket = new DatagramPacket(msg1.getBytes(),msg1.length(),clientAddress, clientPort);
                      
 datagramSocket.send(outPacket);
 }
 
}
}
