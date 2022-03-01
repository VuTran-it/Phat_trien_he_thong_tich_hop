import java.io.IOException;
import java.io.DataInputStream;
import java.net.Socket;

public class Doc extends Thread{
    private Socket socket;

    public Doc(Socket socket){
        this.socket = socket;
    }
    
    public void run(){
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while(true){
                String sms = dis.readUTF();
                System.out.println(sms);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}