import java.io.IOException;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;

public class TCP_Client {
    public final static int  ServerPort = 6789;
    public static void main(String[] args) throws InterruptedException {
        try {
                Socket s = new Socket("127.0.0.1",ServerPort);
                System.out.println("Client duoc tao");

                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();
                for (int i = '0'; i < '9'; i++) {
                    os.write(i);
    
    
                    int ch = is.read();
                    System.out.println((char)ch);
    
                    Thread.sleep(2000);
                }
                s.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
