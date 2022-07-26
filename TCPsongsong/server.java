import java.net.*;
import java.io.*;
import java.util.*;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Server connecting ");
        System.out.println("server connected with port = 8888");
        while (true) {
            Socket socket = server.accept();
            System.out.println("Chao Client " +socket.getPort() );
            String str = "Chao client " + socket.getPort() + "\n" + "1. Gio \n2. Ngay \n3. Ngay va gioi \n4. exit de thoat";
            OutputStream os = socket.getOutputStream();
            os.write(str.getBytes());
            thread t = new thread(socket);
            t.start();
        }
    }
}
