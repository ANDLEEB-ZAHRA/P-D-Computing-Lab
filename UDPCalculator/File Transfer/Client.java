import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Ask user for file name
            System.out.print("Enter file name to send: ");
            String fileName = scanner.nextLine();

            // 🔥 Build correct path automatically
            String fullPath = System.getProperty("user.dir") 
                    + "\\File Transfer\\" + fileName;

            File file = new File(fullPath);

            if (!file.exists()) {
                System.out.println("File not found! Check File Transfer folder.");
                return;
            }

            // Read file content
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            br.close();

            // Connect to server
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server");

            // Send filename + content
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String message = fileName + "||" + content.toString();
            dos.writeUTF(message);

            // Receive confirmation
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String serverMsg = dis.readUTF();
            System.out.println(serverMsg);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}