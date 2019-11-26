/*
Program - 3
Using TCP/IP Sockets, Write a client-server program to make the client send the file name and to make the server send back the contents of the requested file is present.
*/

import java.net.*;
import java.io.*;
class TCPServer
{
    public static void main(String args[]) throws Exception   // establishing the connection with the server
    {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server Ready for Connection:");
        Socket sock = sersock.accept(); // binding with port: 4000
        System.out.println("Connection is Successful and Waiting to Serve"); // reading the file name from client
        InputStream istream = sock.getInputStream();
        BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));
        String fname = fileRead.readLine(); // reading file contents
        BufferedReader contentRead = new BufferedReader(new FileReader(fname) ); // keeping output stream ready to send the contents
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream,true);
        String str;
        while((str = contentRead.readLine()) != null)   //reading line-by-line from file
        {
            pwrite.println(str); // sending each line to client
        }
        sock.close();
        sersock.close(); // closing network sockets
        pwrite.close();
        fileRead.close();
        contentRead.close();
    }
}

