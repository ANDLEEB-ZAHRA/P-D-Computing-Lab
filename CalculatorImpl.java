import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    public CalculatorImpl() throws RemoteException {
        super();
    }

    public double add(double a, double b) {
        double result = a + b;
        System.out.println("Add: " + result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        System.out.println("Subtract: " + result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        System.out.println("Multiply: " + result);
        return result;
    }

    public double divide(double a, double b) {
        double result = (b == 0) ? 0 : a / b;
        System.out.println("Divide: " + result);
        return result;
    }
}