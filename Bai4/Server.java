import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6789);
        System.out.println("DA KHOI DONG SERVER");
        System.out.println("server connected with port = 6789");
        while(true)
        {
            Socket socket = server.accept();
            System.out.println("Chao Client " +socket.getPort());
            DateTime t = new DateTime(socket);
            t.start();
        }
    }
}
