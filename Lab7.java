//Write a simple program to retrieving data from a URL 
import java.net.*;
import java.io.*;
public class Lab7{
    public static void main(String[] args) throws IOException , MalformedURLException{
        URL url = new URL("https://www.rudalkunwar.com.np");

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        br.lines().forEach(System.out::println);

        br.close();
        
    }
}