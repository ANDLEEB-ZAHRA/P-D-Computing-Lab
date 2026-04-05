package UDPCalculator.Lab4task1.Lab4task2;
import java.io.*;
import java.net.*;
public class FileClient {
    public static void main(String[] args) {
        // Ensure you have a file named 'source.txt' in your folder to send
        File fileToSend = new File("UDPCalculator/Lab4task1/Lab4task2/source.txt");
        
        try (Socket socket = new Socket("localhost", 6000);
             FileInputStream fis = new FileInputStream(fileToSend);
             OutputStream os = socket.getOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            System.out.println("File sent successfully.");
        } catch (IOException e) {
            System.err.println("Error: Make sure 'source.txt' exists in the project folder.");
        }
    }
}