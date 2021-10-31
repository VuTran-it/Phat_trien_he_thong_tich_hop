import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

//import java.util.Scanner;
import java.lang.String;

public class Processdon extends Thread{
    Socket channel;
    // nó phải tên là channel mới chịu cơ :)))
    public Processdon(Socket s){
        this.channel = s;
    }

    public void ghifile(String chuoighi, String filename) throws IOException{
        try {
            File file =new File(filename);
            if(!file.exists()){
                file.createNewFile();
                // nếu không có phải tạo file mới chạy được
            }
            FileWriter fw = new FileWriter(file,true);
            //
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            //This will add a new line to the file content
            //pw.println("");
            pw.println("Ghi them: "+ chuoighi);
            pw.close();
            System.out.println("ghi file thanh cong.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            DataInputStream dis = null;
            DataOutputStream dos = null;
            dis = new DataInputStream(channel.getInputStream());
            dos = new DataOutputStream(channel.getOutputStream());
            while(true){
                String s1 = "";
                String s2[];
                s1 = dis.readUTF();
                System.out.println(currentThread().getName()+": chuoi ghi: " + s1);
                //----------------
                //----------------
                s2 = new String[100];
                // cac phan tu trong mang cach nhau boi dau cach
                s2 = s1.split(" ");
                int chieudai = s2.length;
                switch(s2[chieudai - 1]){
                case "HET":
                    //cat chu cuoi cung cua chuoi
                    s1 = s1.substring(0, s1.lastIndexOf(" "));
                    ghifile(s1,"./file1.txt");
                    dos.flush();
                    dos.writeUTF("da ghi xuong file thanh cong.");
                    break;
                default:
                    dos.flush();
                    dos.writeUTF("phai co tu HET cuoi chuoi!");    
                    break;
                }
            }
            //channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
