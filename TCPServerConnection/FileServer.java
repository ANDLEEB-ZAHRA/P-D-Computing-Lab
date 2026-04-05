import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        try {

             ServerSocket server = new ServerSocket(6000);
             System.out.println("server started sucessfully, waiting for a file");
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            BufferedWriter writer = new BufferedWriter(new FileWriter("abs.text"));

            String line;
            while ((line = in.readLine()) != null) {
                writer.write(line);
                writer.newLine();
                
            }

            socket.close();
            server.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println();
        }
    }
}