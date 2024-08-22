import java.rmi.*;
public interface Multiply extends Remote{
    int doMultiply(int x , int y) throws RemoteException;
}