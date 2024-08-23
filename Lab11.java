// 11.Write a program for reading data from server
import java.io.*;
import java.net.*;

public class Lab11 {
    public static void main(String[] args) throws UnknownHostException , IOException {
        String serverAddress = "time.nist.gov"; // A reliable Daytime server
        int port = 13; // Daytime Protocol port

        Socket socket = new Socket(serverAddress, port);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;

        System.out.println("Connected to server.");

        // Read data from the server
        System.out.print("Current time is : ");
        input.lines().forEach(System.out::println);

    }
}
