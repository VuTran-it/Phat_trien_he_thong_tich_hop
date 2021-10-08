import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server1 {
    public final static int ServerPort = 6789;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(ServerPort);
            System.out.println(("SERVER1 da tao"));
            while(true)
            {
                Socket s = ss.accept();
                RequestProcessing rp = new RequestProcessing(s);

                rp.start();     
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
