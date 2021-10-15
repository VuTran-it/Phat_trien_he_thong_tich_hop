import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    
    public Server(int port) {
        this.port = port;
    }

    private void execute() throws IOException {
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        DateTime read = new DateTime(socket);
        read.start();
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server(6789);
        System.out.println("DA KHOI DONG SERVER");
        server.execute();
    }
}
