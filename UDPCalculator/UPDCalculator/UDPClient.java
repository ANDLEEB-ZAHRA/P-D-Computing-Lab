package UDPCalculator;
import java.net.*;
import java.util.Scanner;
public class UDPClient {

    public static void main(String[] args) {

        try {

            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter expression (e.g. 5 + 3): ");
            String msg = sc.nextLine();

            byte[] sendData = msg.getBytes();

            InetAddress ip = InetAddress.getByName("localhost");

            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, ip, 7000);

            socket.send(sendPacket);

            // Receive result
            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            socket.receive(receivePacket);

            String result = new String(receivePacket.getData()).trim();

            System.out.println("Server Response: " + result);

            socket.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}