import java.net.*;

public class Lab2 {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress add1 = InetAddress.getByName("www.ibiblio.org");
        InetAddress add2 = InetAddress.getByName("www.google.com");

        if (add1.equals(add2)) {
            System.out.println("They are the same");
        } else {
            System.out.println("They are different");
        }
    }
}
