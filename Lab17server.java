import java.rmi.registry.*;
public class Server {
    public static void main(String[] args){
        try{
            
            
            Registry reg = LocateRegistry.createRegistry(2500);
            
            MultiplyImplement mult = new MultiplyImplement();
            
            reg.bind("multiply", mult);
            
            System.out.print("Server is running at 2500");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
