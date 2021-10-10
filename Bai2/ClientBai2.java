//package Bai2;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientBai2 {
    private InetAddress host;
    private int port;
    
    public ClientBai2(InetAddress host, int port) {
        this.host = host;
        this.port = port;
    }
    private void execute() throws IOException{
        Socket client = new Socket(host, port);
        Read read = new Read(client);
        read.start();
        Write wite = new Write(client);
        Thread th = new Thread(wite);
        th.start();
    }
    public static void main(String[] args) throws IOException {
        ClientBai2 client = new ClientBai2(InetAddress.getLocalHost(), 6789);
        client.execute();

    }
}
