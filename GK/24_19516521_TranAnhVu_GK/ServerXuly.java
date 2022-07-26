import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ServerXuly extends Thread{
    private static InetAddress clientIP;
    private int clientPort;
    DatagramSocket socket;

    public ServerXuly(DatagramSocket socket){
        try {
            this.socket = socket;
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void run() {
        try {
            while (true) {
                String inputStr = receiveData(socket);
                String inputStr_ND = tach_ND(inputStr);
                String inputStr_fileName = tach_FileName(inputStr);

                if (inputStr_ND.equals("menu")||inputStr_ND.equals("MENU")) {
                    String outputMenu = menu();
                    senData(outputMenu, socket, clientIP, clientPort);
                }

                else {
                    // Swich ... case ... xử lí dữ liệu nhận vào
                    String kqua = "";
                    System.out.println("Nhan duoc : " + inputStr_ND);
                    switch (inputStr_ND) {
                    case "0":
                        kqua = " Cam on da su dung";
                        senData(kqua, socket, clientIP, clientPort);
                        break;
                    case "1":
                        if(kiemtrafile(inputStr_fileName).equals("1"))
                        {
                            String nd_file1 = docfile(inputStr_fileName);
                            senData(nd_file1, socket, clientIP, clientPort);
                        }
                        else
                        {
                            senData(kiemtrafile(inputStr_fileName), socket, clientIP, clientPort);
                            break;
                        }
                        break;
                    case "2":
                        if(kiemtrafile(inputStr_fileName).equals("1"))
                        {
                            kqua = " Nhap ki tu can DEM ";
                            senData(kqua, socket, clientIP, clientPort);
                            try {
                                String inputChuoi = receiveData(socket);
                                char inputChuoi_ND = tach_ND(inputChuoi).charAt(0);
                                String inputChuoi_fileName = tach_FileName(inputChuoi);
                                System.out.println("Tin nhan tu CLient :" + inputChuoi_ND);

                                String nd_file = docfile(inputChuoi_fileName);
                                System.out.println(nd_file);
                                kqua = demSoLanXuatHien(inputChuoi_ND, nd_file);
                                senData(kqua, socket, clientIP, clientPort);
                            } catch (IOException e) {
                                //TODO: handle exception
                            }
                        }
                        else
                        {
                            senData(kiemtrafile(inputStr_fileName), socket, clientIP, clientPort);
                            break;
                        }
                        break;

                    case "3":
                        if(kiemtrafile(inputStr_fileName).equals("1"))
                        {
                            kqua = " Nhap tu can DEM ";
                            senData(kqua, socket, clientIP, clientPort);
                            try {
                                String inputChuoi = receiveData(socket);
                                String inputChuoi_ND = tach_ND(inputChuoi);
                                String inputChuoi_fileName = tach_FileName(inputChuoi);
                                System.out.println("Tin nhan tu CLient :" + inputChuoi_ND);

                                String nd_file = docfile(inputChuoi_fileName);
                                System.out.println(nd_file);
                                kqua = demTu(inputChuoi_ND, nd_file);
                                senData(kqua, socket, clientIP, clientPort);
                            } catch (IOException e) {
                                //TODO: handle exception
                            }
                        }
                        else
                        {
                            senData(kiemtrafile(inputStr_fileName), socket, clientIP, clientPort);
                            break;
                        }
                        break;
                    default:
                        kqua = "Khong co chuc nang nay";
                        senData(kqua, socket, clientIP, clientPort);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    public static String menu() {
        String menu = "\n\n ========= MENU ==========\n" 
                    + "0. Thoat\n" 
                    + "1. Doc file\n" 
                    + "2. Dem so lan ki tu xuat hien\n"
                    + "3. Dem so lan tu xuat hien\n";
        return menu;
    }

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

    public static void ghifile(String inputStr, String fileName) throws IOException {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
                // nếu không có phải tạo file mới chạy được
            }
            FileWriter fw = new FileWriter(file, true);

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            // Thoi gian hien tai
            Date dNow = new Date();
            SimpleDateFormat ti = new SimpleDateFormat("hh:mm:ss");

            // Ghi vao file va ket thuc ghi
            pw.print("(" + ti.format(dNow) + ")" + inputStr +" -- ");
            pw.close();

            // Thong bao thanh cong
            System.out.println("GHI FILE THANH CONG");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String docfile(String filename) throws IOException{
        File f = new File(filename);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String kq ="";
        while (( line = br.readLine()) != null){
            kq = kq.concat(line).concat("\n");
        }
        return kq;
    }

    public static String tach_ND(String inputStr)
    {
        int vitri = inputStr.indexOf(".txt");
        String inputStr_ND = inputStr.substring(vitri+5).trim();
        return inputStr_ND;
    }

    public static String tach_FileName (String inputStr)
    {
        int vitri = inputStr.indexOf(".txt");
        String inputStr_fileName = inputStr.substring(0, vitri+4).trim();
        return inputStr_fileName;
    }

    public String demSoLanXuatHien(char kyTu, String inpuStr)
    {   
        int count = 0 ;
        for (int i = 0; i < inpuStr.length(); i++) {
            if (inpuStr.charAt(i) == kyTu) {
                count++;
            }
        }
        String kqua = "So lan xuat hien cua ky tu " + kyTu +" trong chuoi = " + count;
        return kqua;
    }

    public String demTu (String tu, String inputStr)
    {
        String str=inputStr.replace("\n", " ");
        System.out.println(str);
        String[] ct = str.split("[ ,.]");
        int count = 0 ;
        for (int i = 0; i < ct.length; i++){
            if(ct[i].equals(tu))
            {
                count +=1;
            }
        }
        String kqua = "So lan xuat hien cua tu ( " + tu + " )  trong chuoi = " + count; 
        return kqua; 
    }

    public String kiemtrafile (String filename)
    {
        File f = new File(filename);
        String kqua = "";
        if (f.exists()) {
            kqua = "1";
        } else {
            kqua = " khong co file ban yeu cau ";
        }
        return kqua;
    }
}
