// Write a simple program to process web server logfiles
import java.io.*;
import java.net.*;

public class lab5 {
    public static void main(String[] args) {


        String filename = "/home/rudal-kunwar/network-programming/netwrok-programmig/network-programming-practical/logfile.txt";

        try (FileInputStream fin = new FileInputStream(filename);
             Reader in = new InputStreamReader(fin);
             BufferedReader bin = new BufferedReader(in)) {

            for (String entry = bin.readLine(); entry != null; entry = bin.readLine()) {
                // Separate out the IP address
                int index = entry.indexOf(' ');
                if (index == -1) {
                    // If no space is found, print the entry as is and continue
                    System.out.println(entry);
                    continue;
                }
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);

                // Ask DNS for the hostname and print it out
                try {
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName() + theRest);
                } catch (UnknownHostException ex) {
                    System.err.println(entry);
                }
            }
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
        }
    }
}