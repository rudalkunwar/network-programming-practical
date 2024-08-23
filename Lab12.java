// 12.Getting Information about a Socket
import java.net.*;
import java.io.*;
public class Lab12 {
    public static void main(String[] args) throws SocketException,UnknownHostException,IOException{
        Socket socket = new Socket("localhost", 12345);
        // Setting socket options
        socket.setTcpNoDelay(true);
        socket.setSoLinger(true, 10);
        socket.setSoTimeout(5000);
        socket.setReceiveBufferSize(8192);
        socket.setSendBufferSize(8192);
        socket.setKeepAlive(true);
        // Getting and displaying socket options
        System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());
        System.out.println("SO_LINGER: " + socket.getSoLinger());
        System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());
        System.out.println("SO_RCVBUF: " + socket.getReceiveBufferSize());
        System.out.println("SO_SNDBUF: " + socket.getSendBufferSize());
        System.out.println("SO_KEEPALIVE: " + socket.getKeepAlive());
       
    }
}