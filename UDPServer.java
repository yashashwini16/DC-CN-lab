
import java.net.*;
import java.io.*;
import java.util.*;

public class UDPServer 
{
public static void main(String args[])throws SocketException,IOException
{
DatagramSocket serversocket=new DatagramSocket(9902);

Scanner sc=new Scanner(System.in);
while(true)
{
byte[] receivebuffer=new byte[1024];
byte[] sendbuffer=new byte[1024];
DatagramPacket recvdpkt=new DatagramPacket(receivebuffer,receivebuffer.length);
serversocket.receive(recvdpkt);
InetAddress ip=recvdpkt.getAddress();
int portno=recvdpkt.getPort();
String clientdata= new String(recvdpkt.getData());
System.out.println("\n Client: "+clientdata);
System.out.println("\n Server:");
String serverdata=sc.nextLine();
sendbuffer=serverdata.getBytes();
DatagramPacket sendpacket=new DatagramPacket(sendbuffer,sendbuffer.length,ip,portno);
serversocket.send(sendpacket);
if(serverdata.equalsIgnoreCase("bye"))
{
System.out.println("Connected");
break;
}
}
serversocket.close();

}
}
