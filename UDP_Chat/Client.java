import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        
        try {
            DatagramSocket socket = new DatagramSocket();     
            Scanner sc = new Scanner(System.in);
            InetAddress host = InetAddress.getByName("127.0.0.1");
            int port = 7777;
            while(true){ 
                // Gửi tin nhắn qua server
                System.out.println("Noi dung gui SERVER : ");
                String outputStr= sc.nextLine();

                // Nhập BYE sẽ kết thúc trò chuyện
                if(outputStr.equals("BYE")) break;

                byte[] outputByte = outputStr.getBytes();
                DatagramPacket outputPack = new DatagramPacket(outputByte, outputByte.length,host, port);
                socket.send(outputPack);

                byte[] inputByte = new byte[6000];
                DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
                socket.receive(inputPack);
                String inputStr = new String(inputPack.getData(), 0, inputPack.getLength());
                System.out.println("Server gui lai :  " + inputStr);
            }
            socket.close();
            
        } catch (Exception e) {
        }
    }
}