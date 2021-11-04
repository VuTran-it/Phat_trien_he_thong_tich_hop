import java.net.*;
import java.io.*;
import java.util.*;

public class client {
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Nhap dia chi host");
    String host = sc.nextLine();
    System.out.println("Nhap so port");
    int port = sc.nextInt();
    try {
        Socket socket = new Socket(host,port);
        System.out.println("Client connecting to server");
        InputStream in = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        while(true) {
            System.out.println("Nhan phim bat ki de xem Menu");
            Scanner sc2 = new Scanner(System.in);
            String chucNang = sc2.nextLine();
            os.write(chucNang.getBytes());
            if(chucNang.equals("exit"))
                break;
            byte[] reruslt = new byte[500];
            int n = in.read(reruslt);
            String rerusltStr  = new String(reruslt,0,n);
            System.out.println("Server to client: " + rerusltStr);
        }
        socket.close();
    } catch (IOException e) {
            System.out.println(e);
    }    }
}
