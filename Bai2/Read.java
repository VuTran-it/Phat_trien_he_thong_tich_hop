//package Bai2;


import java.io.IOException;
import java.io.DataInputStream;
import java.net.Socket;

public class Read extends Thread{
    private Socket socket;

    public Read(Socket socket){
        this.socket = socket;
    }
    
    public void run(){
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while(true){
                String sms = dis.readUTF();
                System.out.println("Tin nhan nhan duoc : " + sms);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}