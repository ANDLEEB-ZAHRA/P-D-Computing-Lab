import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server2 {
    public static void main(String[] args) {
        try {
            CalculatorImpl obj = new CalculatorImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", obj);

            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}