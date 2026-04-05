package UDPCalculator;

import java.net.*;


public class UDPServer {


    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(7000);
            System.out.println("UDP Server Started...");

            byte[] receiveData = new byte[1024];

            // Receive packet
            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            socket.receive(receivePacket);

            String input = new String(receivePacket.getData()).trim();
            System.out.println("Received: " + input);

            // Split input (e.g. "5 + 3")
            String[] parts = input.split(" ");

            int num1 = Integer.parseInt(parts[0]);
            String op = parts[1];
            int num2 = Integer.parseInt(parts[2]);

            int result = 0;

            switch (op) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
                default: System.out.println("Invalid Operator");
            }

            String res = "Result: " + result;

            byte[] sendData = res.getBytes();

            InetAddress clientIP = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, clientIP, clientPort);

            socket.send(sendPacket);

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}