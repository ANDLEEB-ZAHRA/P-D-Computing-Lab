import java.io.*;
import java.net.*;

public class server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Receive data
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String receivedData = dis.readUTF();

            // Split filename and content
            String[] parts = receivedData.split("\\|\\|");
            String fileName = parts[0];
            String fileContent = parts[1];

            // 🔥 Create folder to save received files
            File folder = new File("ReceivedFiles");
            if (!folder.exists()) {
                folder.mkdir();
            }

            // Save file inside ReceivedFiles folder
            FileWriter writer = new FileWriter("ReceivedFiles/" + fileName);
            writer.write(fileContent);
            writer.close();

            System.out.println("File saved in ReceivedFiles folder: " + fileName);

            // Send confirmation to client
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Server: File received and saved successfully!");

            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}