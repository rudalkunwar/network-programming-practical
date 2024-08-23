//14.UDP Server 
import java.io.*;
import java.net.*;
public class Lab14Server {
 public static void main(String[] args) {
        int port = 9876; // Arbitrary port number

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("UDP Server started and waiting for connections on port " + port);

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket); // Receive data from client

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + message);

                // Send a response back to the client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String response = "Server received: " + message;
                
                DatagramPacket sendPacket = new DatagramPacket(response.getBytes(), response.length(), clientAddress, clientPort);
                serverSocket.send(sendPacket);

                // Break the loop if you want to stop the server after one message
                // break;
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}