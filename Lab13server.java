//creating server socket
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Lab13Server {
public static void main(String[] args) {
        int port = 12345; // Arbitrary port number for the server

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started and waiting for connections...");

            // Accept client connections
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)) {

                System.out.println("Client connected.");

                // Read data from the client
                String message = input.readLine();
                System.out.println("Received from client: " + message);

                // Send a response to the client
                String response = "Server received: " + message;
                output.println(response);
                System.out.println("Response sent to client: " + response);

            } catch (IOException e) {
                System.err.println("Client connection error: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}