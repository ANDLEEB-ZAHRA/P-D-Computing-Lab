import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentService extends Remote {
    String getStudentInfo() throws RemoteException;
}