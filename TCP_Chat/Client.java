import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private InetAddress host;
    private int port;
    
    public Client(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }
    private void execute() throws IOException{
        Socket client = new Socket(host, port);
        Doc read = new Doc(client);
        read.start();
        Ghi wite = new Ghi(client);
        Thread th = new Thread(wite);
        th.start();
    }
    public static void main(String[] args) throws IOException {
        Client client = new Client(InetAddress.getLocalHost(), 8888);
        System.out.println("Nhan tin voi server :");
        client.execute();

    }
}