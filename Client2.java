import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 7000)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            
            // Send different unique message
            writer.println("Hi from Client2");
            System.out.println("Message sent to server from Client 2.");
        } catch (IOException e) {
            System.err.println("Client 2 Error: " + e.getMessage());
        }
    }
}