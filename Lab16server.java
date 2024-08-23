// 16.Non blocking IO Server
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.net.InetSocketAddress;

public class Lab16Server {
    public static final int PORT = 7000;

    public static void main(String[] args) {
        try {
            // Open a Selector
            Selector selector = Selector.open();

            // Open a ServerSocketChannel
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.bind(new InetSocketAddress(PORT));

            // Register the ServerSocketChannel with the Selector
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server started on port " + PORT);

            while (true) {
                // Wait for an event
                selector.select();

                // Iterate over the selection keys
                var selectedKeys = selector.selectedKeys();
                var iterator = selectedKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        // Accept the connection
                        SocketChannel clientChannel = serverChannel.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("Client connected");
                    } else if (key.isReadable()) {
                        // Read from the client
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(256);
                        int bytesRead = clientChannel.read(buffer);
                        if (bytesRead == -1) {
                            clientChannel.close();
                            System.out.println("Client disconnected");
                        } else {
                            buffer.flip();
                            String message = new String(buffer.array(), 0, bytesRead);
                            System.out.println("Received: " + message);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
