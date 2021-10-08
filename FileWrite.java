
import java.io.FileWriter;

class writeFile {
    synchronized void writeFile(String name, int n ){
        try {
            FileWriter mWrite = new  FileWriter(name);
            for(int i = 0 ;  i < n ; i++)
            {
                String s = " " + (int)(Math.random()*100);
                mWrite.write(s);
                System.out.println("Dang ghi file :" + name);
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
            mWrite.close();
            System.out.println("Ghi file" + name + "thành công");
        } catch (Exception e) {
            //TODO: handle exception
        } 
    }
}

public class FileWrite extends Thread{
    public String name;
    public int n;
    writeFile wFile;
    
    public FileWrite (String name, int n , writeFile wFile)
    {
        this.name = name;
        this.n = n;
        this.wFile = wFile;
    }
    
    
    public void run()
    {
        wFile.writeFile(name, n);
    }
}

class TestFileWrite {
    public static void main(String[] args) {

        writeFile wFile = new writeFile();
        new FileWrite("Bai1.txt", 20, wFile).start();
        new FileWrite("Bai2.txt", 10, wFile).start();
        new FileWrite("Bai3.txt", 10, wFile).start();
    }
}
