import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public final static int serverPort =7;
    public static void main(String[] args) {
    try {
        ServerSocket ss = new ServerSocket(serverPort);
        System.out.println("Server da duoc tao.");
        while(true){
            try {
                Socket s = ss.accept();
                Processdon pr = new Processdon(s);
                pr.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    catch (Exception e) {
        System.out.println("khong tao duoc server !");
    }
    }
}
