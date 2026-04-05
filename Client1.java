import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) {
        // Use the same port as your Server (7000)
        int port = 7000; 

        try (Socket socket = new Socket("localhost", port)) {
            // "true" enables auto-flush so the message is sent immediately
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Sending the message
            out.println("Hello Server! This is the message from Client 1.");
            
            System.out.println("Message sent successfully to the server on port " + port);

        } catch (IOException e) {
            System.out.println("Client 1 Error: " + e.getMessage());
        }
    }
}