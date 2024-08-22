//creating server socket
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class BinaryDataServer {
public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(12345)) {
        System.out.println("Server listening on port 12345");
        while (true) {
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected");// Create input and output streams
        InputStream in = clientSocket.getInputStream();
        OutputStream out = clientSocket.getOutputStream();

        // Read and process binary data
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        System.out.println("Received " + bytesRead + " bytes");

        // Write response
        out.write("Data received".getBytes());
        out.flush();
        
        // Close connections
        in.close();
        out.close();
        clientSocket.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
        }
    }
}