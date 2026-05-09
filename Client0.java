import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client0 {

    public static void main(String[] args) {

        try {

            Registry registry =
                LocateRegistry.getRegistry("localhost", 1099);

            StudentService service =
                (StudentService) registry.lookup("StudentService");

            String result = service.getStudentInfo();

            // Client side output
            System.out.println("Student Information");
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}