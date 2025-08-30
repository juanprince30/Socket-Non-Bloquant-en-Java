import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.lang.System;



public class NonBlockingSocket {

    public void socket() throws IOException{
        try {
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(5000));
            System.out.println("Server listening on port 5000");
            serverSocket.configureBlocking(false);
            System.out.println("Server configuring on non blocking");

            Selector selector = Selector.open();
            serverSocket.register(selector, SelectionKey.OP_ACCEPT); // Surveiller les connexions entrantes
            System.out.println("Serveur lancé sur le port 5000...");

            while (true) {
                selector.select(); // Bloque jusqu’à ce qu’un canal soit prêt
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove();

                    if (key.isAcceptable()) {
                        // 3. Accepter une nouvelle connexion
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                        System.out.println("Nouvelle connexion: " + client.getRemoteAddress());

                    } else if (key.isReadable()) {
                        // 4. Lire les données envoyées par le client
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int bytesRead = client.read(buffer);

                        if (bytesRead == -1) {
                            System.out.println("Client déconnecté: " + client.getRemoteAddress());
                            client.close();
                            key.cancel();
                            continue;
                        }
                        buffer.flip();
                        String message = new String(buffer.array(), 0, buffer.limit());
                        System.out.println("Message reçu: " + message);

                        // Répondre au client
                        buffer.clear();
                        buffer.put(("Echo: " + message).getBytes());
                        buffer.flip();
                        client.write(buffer);
                    }
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
