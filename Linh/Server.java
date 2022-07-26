import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
 
public class Server {
 
    public final static int SERVER_PORT = 7777; // Cổng mặc định của Echo Server
    public final static byte[] BUFFER = new byte[4096]; // Vùng đệm chứa dữ liệu cho gói tin nhận

    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            System.out.println("Binding to port " + SERVER_PORT + ", please wait  ...");
            ds = new DatagramSocket(SERVER_PORT); // Tạo Socket với cổng là 7
            System.out.println("Server started ");
            System.out.println("Waiting for messages from Client ... ");
 
            while (true) { 
               
                Thread thread = new ServerXuly(ds);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } //finally {
        //     if (ds != null) {
        //         ds.close();
        //     }
        // }
    }
}