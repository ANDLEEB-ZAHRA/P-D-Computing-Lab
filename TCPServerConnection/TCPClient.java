import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            System.out.println(10);
            System.out.println(5);
            System.out.println("*");

            socket.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println();
        }
    }
    
}