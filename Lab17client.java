// 17.RMI Client
import java.rmi.registry.*;
public class Client {
    public static void main(String[] args){
        try{
            
            Registry reg = LocateRegistry.getRegistry("localhost",2500);
            
            Multiply stub = (Multiply) reg.lookup("multiply");
            
            int result = stub.doMultiply(10, 3);
            
            System.out.println("The result is :"+result);
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}