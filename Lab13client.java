import java.io.*;
import java.net.*;

public class Lab13Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address (localhost for local testing)
        int port = 12345; // The port the server is listening on

        try (Socket socket = new Socket(serverAddress, port);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server.");

            // Send a message to the server
            System.out.print("Enter message to send to server: ");
            String message = consoleInput.readLine();
            output.println(message);

            // Read the response from the server
            String response = input.readLine();
            System.out.println("Received from server: " + response);

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
