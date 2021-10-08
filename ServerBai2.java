import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBai2 {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6789);
            System.out.println("SERVER bai 2 da khoi dong");
            while(true)
            {
                Socket  s = ss.accept();
                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();
                
                while(true)
                {
                    byte b[] = new byte[100];
                    int n = is.read(b);
                    String kqua = new String(b,0,n);
                    System.out.println("Noi dung tin nhan : " + kqua);

                    String nd = "da nhan tin nhan";
                    os.write(nd.getBytes());
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
