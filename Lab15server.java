// 15.Secured socket Server
import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Arrays;

public class Lab15Server {
    public final static int PORT = 7000;
    public final static String ALGORITHM = "TLS";

    public static void main(String[] args) {
        try {
            // Initialize the SSL context
            SSLContext context = SSLContext.getInstance(ALGORITHM);

            // Load the keystore
            KeyStore ks = KeyStore.getInstance("PKCS12");
            char[] password = "rudalkunwar".toCharArray();
            try (FileInputStream fis = new FileInputStream("server.p12")) {
                ks.load(fis, password);
            }

            // Initialize key manager factory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks, password);

            // Initialize the SSL context with key managers
            context.init(kmf.getKeyManagers(), null, new SecureRandom());

            SSLServerSocketFactory factory = context.getServerSocketFactory();

            // Create an SSL server socket
            try (SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT)) {
                System.out.println("SSL Server started on port " + PORT);

                // Enable all available cipher suites
                serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());

                // Handle client connections
                while (true) {
                    try (SSLSocket clientSocket = (SSLSocket) serverSocket.accept()) {
                        System.out.println("Client connected");

                        // Send a greeting message to the client
                        try (DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())) {
                            dos.writeUTF("Hello from the rudal's server!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException | KeyManagementException | KeyStoreException
                | NoSuchAlgorithmException | CertificateException | UnrecoverableKeyException ex) {
            ex.printStackTrace();
        }
    }
}
