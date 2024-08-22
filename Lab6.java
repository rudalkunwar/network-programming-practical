//  Write a simple program by using all eight methods to split 
// URLs entered on the command line into their component parts.

import java.net.*;
public class Lab6{
    public static void main(String[] args) throws MalformedURLException{
        URL url = new URL("http://example.com:8080/path?query=abc#fragment");
        System.out.println("The protocol is : "+url.getProtocol());
        System.out.println("The host is :"+url.getHost());
        System.out.println("The port is : "+url.getPort());
        System.out.println("The path is : "+url.getPath());
        System.out.println("The file is : "+url.getFile());
        System.out.println("The query is : "+url.getQuery());
        System.out.println("The user info is : "+url.getUserInfo());
        System.out.println("The  reference is : "+url.getRef());

    }
}