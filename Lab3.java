// 3.Write a simple program to list all network interface on the local host
import java.util.*;
import java.net.*;
public class Lab3{
    public static void main(String[] args) throws SocketException{
        
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while(interfaces.hasMoreElements()){
            NetworkInterface ni = interfaces.nextElement();
            System.out.println("Interface name is : "+ni.getName());
            System.out.println("Display name is : "+ni.getDisplayName()+"\n");
        }
    }
}