import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            CalcImplement obj = new CalcImplement();
            System.out.println("khoi tao doi tuong calc thanh cong");

            LocateRegistry.createRegistry(6060);
            Registry reg = LocateRegistry.getRegistry(6060);
            reg.bind("VuTran", obj);
            System.out.println("da dang ky doi tuong VuTran voi registry");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}