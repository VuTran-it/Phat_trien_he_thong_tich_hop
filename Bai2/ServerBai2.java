//package Bai2;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBai2 {
    private int port;
    
    public ServerBai2(int port) {
        this.port = port;
    }

    private void execute() throws IOException {
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        Read read = new Read(socket);
        read.start();
        Write write = new Write(socket);
        Thread th = new Thread(write);
        th.start();
    }
    public static void main(String[] args) throws IOException {
        ServerBai2 server = new ServerBai2(6789);
        System.out.println("DA KHOI DONG SERVER2");
        server.execute();
    }
}
