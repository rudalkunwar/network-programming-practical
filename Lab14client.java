
import java.io.*;
import java.net.*;
public class Lab14Client {
       public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address (localhost for local testing)
        int serverPort = 9876; // Port number of the server

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            InetAddress serverInetAddress = InetAddress.getByName(serverAddress);

            System.out.println("Connected to server. Type your message and press Enter to send.");

            while (true) {
                // Read user input
                System.out.print("Enter message to send to server: ");
                String message = consoleInput.readLine();

                // Send message to server
                DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(), serverInetAddress, serverPort);
                clientSocket.send(sendPacket);

                // Receive response from server
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                clientSocket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from server: " + response);
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}