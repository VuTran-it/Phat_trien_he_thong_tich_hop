import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server
{
    public final static int  ServerPort = 6789;
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(ServerPort);
            System.out.println("SERVER đã được tạo");
            while(true)
            {
                Socket  s = ss.accept();

                InputStream is = s.getInputStream();
                OutputStream os = s.getOutputStream();

                while(true)
                {
                    int ch = is.read();
                    System.out.println((char)ch);

                    if(ch == -1 ) break;
                    os.write(ch);
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}