import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ServerXuLy extends Thread{
    private static InetAddress clientIP;
    private int clientPort;
    DatagramSocket socket;

    public ServerXuLy(DatagramSocket socket){
        try {
            this.socket = socket;
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void run() {
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                wait(200);
                String inputStr = receiveData(socket);
                System.out.println("Client gui : " + inputStr);
                
                System.out.println("Tra loi : ");
                String outputStr = sc.nextLine();
                senData(outputStr, socket, clientIP, clientPort);
            }
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    //Hàm nhận dữ liệu từ client gửi qua 
    public String receiveData (DatagramSocket socket) throws IOException
    {
        
        // Nhận dữ liệu từ client qua
        byte[] inputByte = new byte[6000];
        DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
        socket.receive(inputPack);
        clientIP = inputPack.getAddress();
        clientPort = inputPack.getPort();
        return new String(inputPack.getData()).trim();
    }

    //Hàm dùng để gửi dữ liệu qua client
    public void senData(String outputStr, DatagramSocket socket, InetAddress clientIP, int clientPort)
    {
        try {
            String outputDataStr= outputStr;
            DatagramPacket outputDataPack = new DatagramPacket(outputDataStr.getBytes(), outputDataStr.length(),clientIP, clientPort);
            socket.send(outputDataPack);
        } catch (IOException e) {
            //TODO: handle exception
        }
    }

    // Hàm tạo đỗ trễ cho code 
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
