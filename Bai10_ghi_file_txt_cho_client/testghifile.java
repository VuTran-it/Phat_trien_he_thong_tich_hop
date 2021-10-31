/* import java.io.DataOutputStream;
import java.io.FileOutputStream; */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.io.BufferedWriter;

public class testghifile {
    public void ghifile(String chuoighi, String filename) throws IOException{
        /* File f = new File(filename);
        FileWriter fw = new FileWriter(f);
        //Bước 2: Ghi dữ liệu
        fw.write(chuoighi);
        //Bước 3: Đóng luồng
        fw.close(); */
        /*  FileOutputStream fos = new FileOutputStream(filename);
        DataOutputStream ghi = new DataOutputStream(fos);
        ghi.writeUTF(chuoighi); 
        // cái này lúc được lúc không, còn ra chữ TQ
        */
        //---------------------------ghi nhu the này thì chi dc 1 lan!
        try {
            File file =new File(filename);
            if(!file.exists()){
                file.createNewFile();
            }
            //chỗ này true rất quan trọng, xoá đi là không ghi thêm được
            FileWriter fw = new FileWriter(file,true);

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
    public static void main(String[] args) throws IOException {
        testghifile A = new testghifile();
        A.ghifile("nguyen duy huy 18085591", "./file1.txt");
    }
}
