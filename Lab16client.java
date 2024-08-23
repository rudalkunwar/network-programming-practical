// 16.Non blocking IO client
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.net.InetSocketAddress;

public class Lab16Client {
    public static final String SERVER_ADDRESS = "127.0.0.1";
    public static final int SERVER_PORT = 7000;

    public static void main(String[] args) {
        try {
            // Open a Selector
            Selector selector = Selector.open();

            // Open a SocketChannel
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            // Register the channel with the Selector for connect operation
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT));

            while (true) {
                // Wait for an event
                selector.select();

                var selectedKeys = selector.selectedKeys();
                var iterator = selectedKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isConnectable()) {
                        // Finish the connection
                        SocketChannel channel = (SocketChannel) key.channel();
                        if (channel.finishConnect()) {
                            System.out.println("Connected to server");

                            // Prepare and send data
                            ByteBuffer buffer = ByteBuffer.allocate(256);
                            buffer.put("Hello from the client!".getBytes());
                            buffer.flip();
                            while (buffer.hasRemaining()) {
                                channel.write(buffer);
                            }

                            // Close the channel after sending data
                            channel.close();
                            System.out.println("Data sent and connection closed");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
