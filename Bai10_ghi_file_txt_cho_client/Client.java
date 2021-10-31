import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Client{
    public static void main(String[] args) {
        Socket s = null;
        Scanner sc =new Scanner(System.in);
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            String serverIP = "127.0.0.1";
            int serverPort =7;
            String gui;
            /* try {
                System.out.println("Nhap ip cua Server:");
                serverIP = sc.nextLine();
                System.out.println("Nhap port ket noi: ");
                serverPort = sc.nextInt();
                s = new Socket(serverIP, serverPort);
            } catch (Exception e) {
                System.out.println("khong dung ip va port:");
            } */
            //--------------------------------------------------------
            s = new Socket(serverIP, serverPort);
            System.out.println("Client da duoc tao."); 
            //InputStream is = s.getInputStream();
            //OutputStream os = s.getOutputStream();
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());

            System.out.print("Gui chuoi di: ket thuc bang HET: ");
            gui = sc.nextLine();
            //phải so sánh theo kiểu này thì mới hoạt động được
            while(!gui.equals("exit"))
            {
                String nhan ="";
                dos.flush();
                dos.writeUTF(gui);

                nhan = dis.readUTF();
                System.out.println("Server: " + nhan);
                //---------------------------------------
                System.out.print("Gui chuoi di: ket thuc bang HET: ");
                gui = sc.nextLine();
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}