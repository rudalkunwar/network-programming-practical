// 10.Write a program for Demostrate URLConnection.
import java.net.*;
import java.io.*;

public class Lab10 {
    public static void main(String[] args) throws MalformedURLException,IOException {
    
            // Specify the URL to connect to
            URL url = new URL("https://rudalkunwar.com.np"); // Replace with any valid URL

            // Open a connection to the URL
            URLConnection uc = url.openConnection();

            // Display some information about the connection
            System.out.println("URL: " + uc.getURL());
            System.out.println("Content Type: " + uc.getContentType());
            System.out.println("Content Length: " + uc.getContentLength());
            System.out.println("Last Modified: " + uc.getLastModified());
            System.out.println("Expiration: " + uc.getExpiration());
    }
}