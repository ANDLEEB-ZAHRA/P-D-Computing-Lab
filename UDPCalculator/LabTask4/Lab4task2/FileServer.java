package UDPCalculator.Lab4task1.Lab4task2;

import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FileServer {
    private static AtomicInteger fileCounter = new AtomicInteger(1);

    public static void main(String[] args) {
        int port = 6000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("File Server waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                new FileHandler(socket, fileCounter.getAndIncrement()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileHandler extends Thread {
    private Socket socket;
    private int fileNum;

    public FileHandler(Socket socket, int fileNum) {
        this.socket = socket;
        this.fileNum = fileNum;
    }

    public void run() {
        String fileName = "file" + fileNum + ".txt";
        try (InputStream is = socket.getInputStream();
             FileOutputStream fos = new FileOutputStream(fileName)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Saved: " + fileName);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}