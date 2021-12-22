import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            ChucNang_Implement obj = new ChucNang_Implement();
            System.out.println("KHOI TAO CALC THANH CONG");

            LocateRegistry.createRegistry(8888);
            Registry reg = LocateRegistry.getRegistry(8888);
            reg.bind("VuTran", obj);
            System.out.println("DA DANG KY DOI TUONG ( VUTRAN ) VOI RESGISTRY");
            System.out.println("=========== PORT = 8888 ============");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}