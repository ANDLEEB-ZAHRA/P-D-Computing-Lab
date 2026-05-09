import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server0 {
    public static void main(String[] args) {

        try {
            StudentServiceImpl obj = new StudentServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("StudentService", obj);

            System.out.println("Server is running...");

        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}