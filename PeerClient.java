import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PeerClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Apna computer name nikalna
            String myName = InetAddress.getLocalHost().getHostName();

            System.out.print("Enter Target IP (or 'localhost'): ");
            String targetIP = sc.nextLine();

            Socket socket = new Socket(targetIP, 1000);
            System.out.println("[SYSTEM] Connected to peer successfully!");

            System.out.print("Enter message: ");
            String message = sc.nextLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Format: "Name:Message" bhej rahe hain
            out.println(myName + ":" + message);

            System.out.println("[SUCCESS] Message sent by " + myName);
            socket.close();
            
        } catch (Exception e) {
            System.out.println("[ERROR] Could not connect. Check IP or PeerNode status.");
        }
    }
}