import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class Lab15Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Server address
        int port = 7000; // Port number used by the server
        String trustStoreFile = "client.truststore"; // Path to the truststore
        String trustStorePassword = "rudalkunwar"; // Password for the truststore

        try {
            // Load the truststore
            KeyStore trustStore = KeyStore.getInstance("JKS");
            try (FileInputStream trustStoreInput = new FileInputStream(trustStoreFile)) {
                trustStore.load(trustStoreInput, trustStorePassword.toCharArray());
            }

            // Initialize trust manager factory
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);

            // Initialize SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), new java.security.SecureRandom());

            SSLSocketFactory factory = sslContext.getSocketFactory();
            try (SSLSocket socket = (SSLSocket) factory.createSocket(serverAddress, port)) {
                // Optionally, set the enabled cipher suites
                String[] supported = socket.getSupportedCipherSuites();
                socket.setEnabledCipherSuites(supported);

                // Receive data from the server
                try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                    String response = dis.readUTF();
                    System.out.println("Received from server: " + response);
                }
            } catch (IOException e) {
                System.err.println("I/O error: " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
