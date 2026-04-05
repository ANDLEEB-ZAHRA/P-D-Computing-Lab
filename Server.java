import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
      
        try (ServerSocket serverSocket = new ServerSocket(7000)) {
            System.out.println("Server is running... Waiting for clients to connect.");

            // Handling the first client connection
            try (Socket socket1 = serverSocket.accept()) {
                System.out.println("Client 1 connected successfully.");
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                String message1 = reader1.readLine();
                System.out.println("Message from Client 1: " + message1);
                socket1.close();
            }
            // Handling the second client connection
            try (Socket socket2 = serverSocket.accept()) {
                System.out.println("Client 2 connected successfully.");
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                String message2 = reader2.readLine();
                System.out.println("Message from Client 2: " + message2);
                socket2.close();
            }
              System.out.println("\nTask Completed: Both messages received. Server closing.");    
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}