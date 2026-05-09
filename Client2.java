import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculator calc = (Calculator) registry.lookup("CalculatorService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            double a = sc.nextDouble();

            System.out.print("Enter second number: ");
            double b = sc.nextDouble();

            System.out.println("Choose operation: +  -  *  /");
            char op = sc.next().charAt(0);

            double result = 0;

            switch (op) {
                case '+':
                    result = calc.add(a, b);
                    break;
                case '-':
                    result = calc.subtract(a, b);
                    break;
                case '*':
                    result = calc.multiply(a, b);
                    break;
                case '/':
                    result = calc.divide(a, b);
                    break;
                default:
                    System.out.println("Invalid operation!");
                    return;
            }

            System.out.println("Result = " + result);

        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}