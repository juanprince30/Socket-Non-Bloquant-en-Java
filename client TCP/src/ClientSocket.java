import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.io.*;
import java.util.Scanner;

public class ClientSocket {
    public  void connect() throws Exception {
        /*Socket socket = new Socket("localhost", 5000);

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        String message = "Hello from client!\n";
        out.write(message.getBytes());

        byte[] buffer = new byte[1024];
        int read = in.read(buffer);
        String response = new String(buffer, 0, read);
        System.out.println("Réponse du serveur : " + response);

        socket.close();*/
        try {
            // Connexion au serveur
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connecté au serveur sur le port 5000");

            // Streams
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            Scanner scanner = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            while (true) {
                System.out.print("Message à envoyer (ou 'exit' pour deconnecter) : ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Déconnexion en cours...");
                    break;
                }

                // Envoyer message
                out.write((message + "\n").getBytes());
                out.flush();

                // Lire la réponse
                String response = reader.readLine(); 
                System.out.println("Réponse du serveur : " + response);
            }

            // Fermeture
            socket.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




