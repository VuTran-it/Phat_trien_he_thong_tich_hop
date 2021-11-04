import java.net.*;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.Date;


public class thread extends Thread{

    Socket socket;
    public thread(Socket socket){
        this.socket = socket;
    }
    public void run() {
        try {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            while(true) {
                byte[] messbytes = new byte[500];
                int n = is.read(messbytes);
                String mess = new String(messbytes, 0, n);
                String reruslt = "";
                switch (mess){
                    case "1":
                         reruslt = gioHT();
                         break;
                    case "2":
                         reruslt = ngayHT();
                         break;
                    case "3":
                         reruslt = ngaygioHT();
                         break;
                    default: reruslt = ("Server khong ton tai chuc nang nay !");
                   
                }
                os.write(reruslt.getBytes());

            }
            // System.out.println("da ngat ket noi");
            // socket.close();

        } catch (IOException e) {
           System.out.println("Loi nua roi"+ e);
        }
        
    }
    public String ngayHT(){
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
        return ft.format(date);
    }
    public String gioHT(){
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss"); 
        return ft.format(date);
    }
    public String ngaygioHT(){
        Date date = new Date();
        String dateStr = date.toString();
        return dateStr;
    }
}
