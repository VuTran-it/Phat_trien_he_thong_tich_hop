import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ghi implements Runnable {
    private Socket socket;

    public Ghi(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        try {
            DataOutputStream doc = new DataOutputStream(socket.getOutputStream());
            while(true) {
                String sms = sc.nextLine();
                doc.writeUTF("Tin nhan nhan duoc :" + sms);
                doc.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        sc.close();
    }
    
}