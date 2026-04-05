import java.io.*;
import java.net.*;

public class PeerNode {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1000)) {
            // My Local Identity
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("--- My Info ---");
            System.out.println("Name: " + local.getHostName());
            System.out.println("IP:   " + local.getHostAddress());
            System.out.println("Waiting for connection...");

            while (true) {
                Socket socket = server.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                // Format receive hoga: "SenderName:Message"
                String rawData = input.readLine(); 

                if (rawData != null && rawData.contains(":")) {
                    String[] parts = rawData.split(":", 2);
                    String senderName = parts[0]; // Pehla hissa Name
                    String actualMsg = parts[1];  // Dusra hissa Message

                    System.out.println("\n[SYSTEM] Peer connected!");
                    System.out.println("Message:   " + actualMsg);
                    System.out.println("From IP:   " + socket.getInetAddress().getHostAddress());
                    System.out.println("From Name: " + senderName);
                }
                
                socket.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}