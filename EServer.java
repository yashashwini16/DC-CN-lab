 import java.net.*;
import java.io.*;
public class EServer
{
public static void main(String args[])
{
ServerSocket s=null;
String line;

PrintStream ps;
Socket c=null;

BufferedReader is
          = new BufferedReader(new InputStreamReader(System.in));
try
{
s=new ServerSocket(9000);
}
catch(IOException e)
{
System.out.println(e);
}
try
{
c=s.accept();

ps=new PrintStream(c.getOutputStream());
while(true)
{
line=is.readLine();
ps.println(line);
}
}
catch(IOException e)
{
System.out.println(e);
}
}
}


 
