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
            System.out.println("Nhap file name (Max = 12 ki tu): ");
            String fileName = sc.nextLine();
            while(true){ 
                // Nhập nội dung gửi cho server
                System.out.println("Noi dung gui SERVER : ");
                String outputStr_ND = sc.nextLine();
                String outputStr = fileName + ".txt " + outputStr_ND;
                
                //Đóng gói và gửi cho server
                byte[] outputByte = outputStr.getBytes();
                DatagramPacket outputPack = new DatagramPacket(outputByte, outputByte.length,host, port);
                socket.send(outputPack);
                
                //Kiểm tra điều kiện để thoát khỏi server
                if(outputStr_ND.equals("bye")) break;

                // Nhận dữ liệu từ server truyền lại
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