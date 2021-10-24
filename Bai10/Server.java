import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Server {
    private final static int port = 7777;
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("UDP SERVER DA DUOC TAO");
            Scanner sc = new Scanner(System.in);
            while(true){
                //Nhận dữ liệu từ client qua
                byte[] inputByte = new byte[6000];
                DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
                socket.receive(inputPack);
                String inputStr = new String(inputPack.getData(), 0, inputPack.getLength());
                String inputStr_ND = inputStr.substring(12).trim();
                String inputStr_fileName = inputStr.substring(0,12).trim();
               
                //In nội dung nhận được từ client nào
                System.out.println("Noi dung nhan duoc : " + inputStr_ND );

                //Lưu nội dung vào file 
                ghifile(inputStr_ND,inputStr_fileName);

                //Trả lời lại client 
                System.out.println("Ban noi: ");
                String str1 = sc.nextLine();
                DatagramPacket gui = new DatagramPacket(str1.getBytes(), str1.length(), inputPack.getAddress(), inputPack.getPort());
                socket.send(gui);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void ghifile(String inputStr, String fileName) throws IOException{
        try {
            File file =new File(fileName);
            if(!file.exists()){
                file.createNewFile();
                // nếu không có phải tạo file mới chạy được
            }
            FileWriter fw = new FileWriter(file,true);

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            // Thoi gian hien tai 
            Date dNow = new Date( );
            SimpleDateFormat ti = new SimpleDateFormat ("hh:mm:ss");

            // Ghi vao file va ket thuc ghi
            pw.println("(" + ti.format(dNow) + ")" + inputStr);
            pw.close();

            //Thong bao thanh cong
            System.out.println("GHI FILE THANH CONG");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}