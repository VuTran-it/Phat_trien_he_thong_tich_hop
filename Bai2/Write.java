//package Bai2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Write implements Runnable {
    private Socket socket;

    public Write(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("Nhap Tin Nhan : ");
        Scanner sc = new Scanner(System.in);
        try {
            DataOutputStream doc = new DataOutputStream(socket.getOutputStream());
            while(true) {
                String sms = sc.nextLine();
                doc.writeUTF(sms);
                doc.flush();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        sc.close();
    }
    
}
