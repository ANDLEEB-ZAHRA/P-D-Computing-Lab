package UDPCalculator.Lab4task1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter your name (e.g., Client1): ");
            String name = sc.nextLine();

            System.out.println("Type your message (or 'exit' to quit):");
            while (true) {
                String msg = sc.nextLine();
                if (msg.equalsIgnoreCase("exit")) break;
                out.println(name + ": " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}