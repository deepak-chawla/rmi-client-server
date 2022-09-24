import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient{
public static void main(String[] args) throws Exception {
 
byte[] buffer = new byte[256];  					   

String msg = "";

 DatagramSocket datagramSocket =    new DatagramSocket();   
 Scanner cmdinput = new Scanner(System.in);         


while(!msg.equalsIgnoreCase("CLOSE")){
 
 System.out.print("Enter reply to Server: ");

 msg = cmdinput.next();
 
 DatagramPacket outPacket = new DatagramPacket(msg.getBytes(),msg.length(),InetAddress.getLocalHost(),1234);       
 
 datagramSocket.send(outPacket);                                        	
	          
 DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length); 
 
 datagramSocket.receive(inPacket);					           
 
 String message = new String(inPacket.getData(),0,inPacket.getLength()); 

 System.out.println("Server says: " + message); 	                     		   
 }
 
}
}

