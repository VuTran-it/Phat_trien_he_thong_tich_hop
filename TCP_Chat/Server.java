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
        Doc read = new Doc(socket);
        read.start();
        Ghi write = new Ghi(socket);
        Thread th = new Thread(write);
        th.start();
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server(8888);
        System.out.println("SERVER DA KHOI TAO");
        server.execute();
    }
}