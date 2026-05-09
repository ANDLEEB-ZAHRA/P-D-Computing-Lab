import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {

    String name = "Ali";
    int marks = 85;

    public StudentServiceImpl() throws RemoteException {
        super();
    }

    public String getStudentInfo() {

        String data = "Student Name: " + name + "\nMarks: " + marks;

        // Server side output
        System.out.println("Client requested data");
        System.out.println(data);

        return data;
    }
}