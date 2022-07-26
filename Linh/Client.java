import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public final static byte[] BUFFER = new byte[4096]; // Vùng đệm chứa dữ liệu cho gói tin nhận
    public final static String host = "127.0.0.1";
    public final static int port = 7777; // Cổng mặc định của Echo Server
    
    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
		// System.out.println("Nhap dia chi host");
		// String host = sc.nextLine();
		// System.out.println("Nhap so port");
		// int port = sc.nextInt();

        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(); // Tạo DatagramSocket
            System.out.println("Client started ");
            InetAddress server = InetAddress.getByName(host);

            InputStreamReader isr = new InputStreamReader(System.in); // Nhập
            BufferedReader br = new BufferedReader(isr); // một chuỗi


            while (true) {
                //Hien thi menu
                
                System.out.println("Enter your string: ");
                
                String theString = br.readLine(); // từ bàn phím
                byte[] data = theString.getBytes(); // doi chuoi ra bytes
 
                // Tạo gói tin gởi
                DatagramPacket dp = new DatagramPacket(data, data.length, server, port);
                ds.send(dp); // Send gói tin sang  Server

                if(theString.equals("0")){
                    byte[] inputByte1 = new byte[6000];
                    DatagramPacket inputPack1 = new DatagramPacket(inputByte1, inputByte1.length);
                    ds.receive(inputPack1);
                    String inputStr1 = new String(inputPack1.getData(), 0, inputPack1.getLength());
                    System.out.println("Server gui lai :  " + inputStr1);   
                    break;
                } 

                System.out.println("ma Ling ");
                // Gói tin nhận
                DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
                ds.receive(incoming); // cho nhan du lieu tu server
                // doi du lieu ra dang byte va in ra man hinh
                System.out.println("Received from Server: " + new String(incoming.getData(), 0, incoming.getLength()));
            }
            ds.close();
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}