//  4.Write a simple program to illustrate spam check
import java.net.*;
public class SpamCheck {

    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) {
        if (isSpammer(args[0])) {
            System.out.println(args[0] + " is a known spammer.");
        } else {
            System.out.println(args[0] + " appears legitimate.");
        }
    }

    private static boolean isSpammer(String ip) {
        try {
            String query = reverseIP(ip) + "." + BLACKHOLE;
            InetAddress.getByName(query); // DNS lookup
            return true; // IP is listed in the DNSBL
        } catch (UnknownHostException e) {
            return false; // IP is not listed in the DNSBL
        }
    }

    private static String reverseIP(String ip) {
        String[] parts = ip.split("\\.");
        return parts[3] + "." + parts[2] + "." + parts[1] + "." + parts[0];
    }
}
