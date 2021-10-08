import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientBai2 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",6789);
            System.out.println("Client bai 2 da chay");

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            System.out.println("Tin nhan can gui di : ");
            Scanner sc = new Scanner(System.in);

            String mes = sc.nextLine();

            os.write(mes.getBytes());

            byte a[] = new byte[100];
            int n = is.read(a);
            String kqua = new String(a,0,n);
            System.out.println("Noi dung nhan lai : " + kqua);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
