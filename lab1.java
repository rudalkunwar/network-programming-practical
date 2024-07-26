//1. Testing the characteristics of an IP address.
import java.net.*;
public class Lab1{

    public static void main(String[] args){
        
      try{
        InetAddress address = InetAddress.getByName("www.rudalkunwar.com.np");
        if(address.isAnyLocalAddress()){
            System.out.println(address+" is wildcard Address");
        }
        if(address.isLoopbackAddress()){
            System.out.println(address+" is Lookback address");
        }
        if(address.isLinkLocalAddress()){
            System.out.println(address+" is Link-Local address");
        }
        else if(address.isSiteLocalAddress()){
            System.out.println(address+" is Site-Local address");
        }else{
            System.out.println(address+" is Global address");
        }
        if(address.isMulticastAddress()){
            if(address.isMCGlobal()){
            System.out.println(address+" is Global MC address");
            }else if(address.isMCOrgLocal()){
            System.out.println(address+" is Organization MC address");
            }else if(address.isMCLinkLocal()){
            System.out.println(address + " is a subnet wide MC address");
            }else if(address.isMCNodeLocal()){
            System.out.println(address + " is an interface-local MC address");
            }else{
            System.out.println(address + " is an Unknown MC address");
            }
        }else{
            System.out.println(address+" is unicast Address");
        }
      }catch(UnknownHostException e){
        e.printStackTrace();
      }
    }
}