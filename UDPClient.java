import java.io.*;
import java.util.*;
import java.net.*;
public class UDPClient
{
public static void main(String args[])throws SocketException,IOException
{
Scanner sc=new Scanner(System.in);
InetAddress ip=InetAddress.getByName("localhost");
DatagramSocket clientsocket=new DatagramSocket();
while(true)
{
byte[] sendbuffer=new byte[1024];
byte[] receivebuffer=new byte[1024];
System.out.println("\n Client:");
String clientdata=sc.nextLine();
sendbuffer=clientdata.getBytes();
DatagramPacket sendpacket=new DatagramPacket(sendbuffer,sendbuffer.length,ip,9902);
clientsocket.send(sendpacket);
if(clientdata.equalsIgnoreCase("bye"))
{
System.out.println("connection end by client");
break;
}
DatagramPacket receivepacket=new DatagramPacket(receivebuffer,receivebuffer.length);
clientsocket.receive(receivepacket);
String serverdata=new String(receivepacket.getData());
System.out.println("\n Server:"+serverdata);
}
clientsocket.close();
sc.close();
}
}

