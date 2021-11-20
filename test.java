import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class test {
    public static void main(String[] args) {
        try {
            String filename = "banner.txt";
            String noidung = docfile(filename);
            String chuoi = "\n"+ noidung;

            System.out.println("Noi dung : " + chuoi);
        } catch (IOException e) {
            //TODO: handle exception
        }
    }

    public static String docfile(String filename)throws IOException
    {
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String kq ="";
        while (( line = br.readLine()) != null){
            wait(200);
            kq = kq.concat(line).concat("\n");
        }
        return kq;
    }
    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
