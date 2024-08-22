import java.rmi.registry.*;
public class Server {
    public static void main(String[] args){
        try{

            MultiplyImplement mult = new MultiplyImplement();
            Registry reg = LocateRegistry.createRegistry(3000);
            reg.bind("multiply",mult);
            System.out.println("The server is running at port : 3000 ");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}