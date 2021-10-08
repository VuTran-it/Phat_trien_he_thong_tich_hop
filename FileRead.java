
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.String;

public class FileRead extends Thread{
    private String fileName;
    
    public FileRead(String fileName) {
        this.fileName = fileName;
    }

    public void run(){
        try {
            // FileOutputStream fos = new FileOutputStream("./bai1.txt");
            // DataOutputStream ghi = new DataOutputStream(fos);
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
              System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String bai1 = "./bai1.txt";
        String bai2 = "./bai2.txt";
        String bai3 = "./bai3.txt";
        FileRead t1 = new FileRead(bai1);
        FileRead t2 = new FileRead(bai2);
        FileRead t3 = new FileRead(bai3);
        t1.start();
        t2.start();
        t3.start();
    }
}