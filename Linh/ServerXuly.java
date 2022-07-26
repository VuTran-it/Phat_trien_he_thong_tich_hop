import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ServerXuly extends Thread {
    private static InetAddress clientIP;
    private int clientPort;
    DatagramSocket socket;

    public ServerXuly(DatagramSocket socket) {
        try {
            this.socket = socket;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void run() {
        try {
            while (true) {
                String inputStr = receiveData(socket);

                // Hien thi menu
                if (inputStr.equals("menu") || inputStr.equals("MENU")) {
                    wait(500);
                    String outputMenu = menu();
                    senData(outputMenu, socket, clientIP, clientPort);
                } else {
                    String kqua = "";
                    System.out.println("Client da chon phuong thuc: " + inputStr);
                    switch (inputStr) {
                        case "0":
                            kqua = "Cam On Ban Da Su Dung He Thong";
                            senData(kqua, socket, clientIP, clientPort);
                            socket.close();
                            break;
                        case "1":
                            kqua = "Hay nhap chuoi ki tu can dem";
                            senData(kqua, socket, clientIP, clientPort);
                            while (true) {
                                try {
                                    String inputChuoi = receiveData(socket);

                                    System.out.println("Tin nhan tu CLient :" + inputChuoi);

                                    // Nhận chuỗi kí tự cần xử lý

                                    // if (inputChuoi.equals("exit")) 
                                    // {
                                    //     socket.close();
                                    //     break;

                                    // } else {
                                        StringTokenizer stringTokenizer = new StringTokenizer(inputChuoi);
                                        kqua = ("So tu can dem la: " + stringTokenizer.countTokens());
                                        senData(kqua, socket, clientIP, clientPort);
                                        break;
                                    // }
                                } catch (IOException e) {
                                    // TODO: handle exception
                                }
                            }
                            break;

                        default:
                            kqua = "Khong co chuc nang nay";
                            senData(kqua, socket, clientIP, clientPort);
                    }
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String menu() {
        String menu = "\n\n ========= MENU ==========\n"
                + "0.Thoat\n"
                + "1. Dem so tu\n"
                + "2. Dao chuoi\n"
                + "Nhap lua chon\n";

        return menu;
    }

    // Hàm nhận dữ liệu từ client gửi qua
    public String receiveData(DatagramSocket socket) throws IOException {

        // Nhận dữ liệu từ client qua
        byte[] inputByte = new byte[6000];
        DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
        socket.receive(inputPack);
        clientIP = inputPack.getAddress();
        clientPort = inputPack.getPort();
        return new String(inputPack.getData()).trim();
    }

    // Hàm dùng để gửi dữ liệu qua client
    public void senData(String outputStr, DatagramSocket socket, InetAddress clientIP, int clientPort) {
        try {
            String outputDataStr = outputStr;
            DatagramPacket outputDataPack = new DatagramPacket(outputDataStr.getBytes(), outputDataStr.length(),
                    clientIP, clientPort);
            socket.send(outputDataPack);

        } catch (IOException e) {
            // TODO: handle exception
        }
    }
    // Tách nội dung từ chuỗi client gửi
    // public static String tach_ND(String inputStr)
    // {
    // int vitri = inputStr.indexOf(".txt");
    // String inputStr_ND = inputStr.substring(vitri+5).trim();
    // return inputStr_ND;
    // }

    // Hàm tạo đỗ trễ cho code
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
