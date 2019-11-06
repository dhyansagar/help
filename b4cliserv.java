//Client Program
import java.io.*;
import java.net.*;
class UDPC
{
public static void main(String args[]) throws Exception
{
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
DatagramSocket clientSocket = new DatagramSocket();
InetAddress IPAddress = InetAddress.getByName("localhost");
byte[] sendData = new byte[1024];
byte[] receiveData = new byte[1024];
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
clientSocket.send(sendPacket);
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
clientSocket.receive(receivePacket);
String modifiedSentence = new String(receivePacket.getData());
System.out.println("FROM SERVER:" + modifiedSentence);
clientSocket.close();
}
}
//Server Program
import java.io.*;
import java.net.*;
class UDPS
{
public static void main(String args[]) throws Exception
{
DatagramSocket serverSocket = new DatagramSocket(9876);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
byte[] receiveData = new byte[1024];
byte[] sendData = new byte[1024];
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
serverSocket.receive(receivePacket);
InetAddress IPAddress = receivePacket.getAddress();
int port = receivePacket.getPort();
System.out.println("Enter the Message");
String data = br.readLine();
sendData = data.getBytes();
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port);
serverSocket.send(sendPacket);
serverSocket.close();
}
}