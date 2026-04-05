import java.io.*;
import java.net.*;

public class TCPServerCalculation {
    public static void main(String[] args) {
        try {
             ServerSocket server = new ServerSocket(5001);
            System.out.println("server is waiting");

            Socket socket = server.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int num1 =Integer.parseInt(input.readLine());
            int num2 =Integer.parseInt(input.readLine());

            String op = input.readLine();

            int result = 0;
            if(op.equals("+")) result = num1+num2;
            if(op.equals("*")) result = num1*num2;
            if(op.equals("/")) result = num1/num2;


            System.out.println("Result is:"+result);
            

            socket.close();
            server.close();

        } catch (Exception e) {
            // TODO: handle exception
             System.err.println();
        }
    }
    
}