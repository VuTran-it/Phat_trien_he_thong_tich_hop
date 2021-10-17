import java.net.Socket;
import java.io.*;
import java.net.*;

public class DateTime extends Thread {
    Socket socket;

    public DateTime(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            while (true) {
                String menu = "\n MENU \n 0. Thoat \n 1. Time \n 2. Date \n 3. Date & Time \n Nhap lua chon :";
                os.write(menu.getBytes());
                // Nhan ky tu tu Client
                int ch = is.read();
                // Xu ly va tra ket qua
                String kqua = "";
                switch (ch) {
                    case '0':
                        break;
                    case '1':
                        kqua = " " + java.time.LocalTime.now();
                        break;
                    case '2':
                        long millis = System.currentTimeMillis();
                        java.sql.Date date = new java.sql.Date(millis);
                        kqua = " " + date;
                        break;
                    case '3':
                        java.util.Date date1 = new java.util.Date();
                        kqua = " " + date1;
                        break;
                    default:
                        kqua = "Khong co chuc nang nay";
                }
                // Gui tra ket qua sang Client
                os.write(kqua.getBytes());
                Thread.sleep(500);
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
