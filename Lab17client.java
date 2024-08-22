public class Client{
    public static void main(String[] args){
        try{

            Registry reg = LocateRegistry.getRegistry("localhost",3000);
            Multiply stub = (Multiply) reg.lookup("multiply");

            int mul = stub.doMultiply(10,20);
            System.out.println("The result is : "+mul);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}