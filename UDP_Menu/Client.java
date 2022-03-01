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
            
            // Dang nhap bang tai khoan admin moi duoc quyen xem va nhap du lieu
            System.out.println("Nhap username : ");
            String username = sc.nextLine();
            System.out.println("Nhap mat khau (port) : ");
            // Xử lý lỗi trôi lệnh
            int port = Integer.parseInt(sc.nextLine());

            if((username.equals("admin")) && (port == 8888))
            {
                System.out.println("Nhap ma so sinh vien : ");
                String fileName = sc.nextLine();
                System.out.println("==== Nhap MENU de xem duoc MENU ====");
                while(true){ 
                    // Gửi yêu cầu qua server
                    System.out.println("Noi dung gui SERVER : ");
                    String outputStr_ND = sc.nextLine();
                    String outputStr = fileName + ".txt " + outputStr_ND;

                    byte[] outputByte = outputStr.getBytes();
                    DatagramPacket outputPack = new DatagramPacket(outputByte, outputByte.length,host, port);
                    socket.send(outputPack);
                    
                    if(outputStr_ND.equals("0"))
                    {
                        byte[] inputByte1 = new byte[6000];
                        DatagramPacket inputPack1 = new DatagramPacket(inputByte1, inputByte1.length);
                        socket.receive(inputPack1);
                        String inputStr1 = new String(inputPack1.getData(), 0, inputPack1.getLength());
                        System.out.println("Server gui lai :  " + inputStr1);   
                        break;
                    } 

                    byte[] inputByte = new byte[6000];
                    DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
                    socket.receive(inputPack);
                    String inputStr = new String(inputPack.getData(), 0, inputPack.getLength());
                    System.out.println("Server gui lai :  " + inputStr);
                }
                socket.close();
            }
            else
            {
                System.out.println(" Tai khoan cua ban chua chinh xac !!!!!!!!!!!!!!");
            }
            
        } catch (Exception e) {
        }
    }
}