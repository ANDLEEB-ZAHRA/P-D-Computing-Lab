import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("server is waiting");

            Socket socket = server.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int num1 =Integer.parseInt(input.readLine());
            int num2 =Integer.parseInt(input.readLine());

            System.out.println("my first number is:"+num1);
            System.out.println("my Second number is:"+num2);

            socket.close();
            server.close();


        } catch (Exception e) {
            // TODO: handle exception
            System.err.println();
        }
    }
}