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
                    System.out.println(inputStr_ND);
                    switch (inputStr_ND) {
                    case "0":
                        break;
                    case "1":
                        kqua = " Nhap chuoi, ket thuc bang chu HET";
                        senData(kqua, socket, clientIP, clientPort);
                        while(true)
                        {
                            try {
                                String inputChuoi = receiveData(socket);
                                String inputChuoi_ND = tach_ND(inputChuoi);
                                String inputChuoi_fileName = tach_FileName(inputChuoi);
                                System.out.println("Tin nhan tu CLient :" + inputChuoi_ND);
    
                                if(inputChuoi_ND.indexOf("HET")!=-1)     
                                {
                                    ghifile(daochuoi(inputChuoi_ND), inputChuoi_fileName);
                                    kqua = "Da ghi file " + inputChuoi_fileName;
                                    senData(kqua, socket, clientIP, clientPort);
                                    break;
                                }    
                                else
                                {
                                    kqua = " Ket thuc bang chu HET nha ban";
                                    senData(kqua, socket, clientIP, clientPort);
                                }
                            } catch (IOException e) {
                                        //TODO: handle exception
                            }
                        }
                        break;
                    case "2":
                        kqua = docfile(inputStr_fileName);
                        System.out.println("DOC FILE THANH CONG");
                        senData(kqua, socket, clientIP, clientPort);
                        break;

                    case "3":
                        kqua = "Nhap chuoi so can tinh, ket thuc bang dau 'cham' ";
                        senData(kqua, socket, clientIP, clientPort);
                        while(true)
                        {
                            try {
                                String inputChuoi = receiveData(socket);
                                String inputChuoi_ND = tach_ND(inputChuoi);
                                String inputChuoi_fileName = tach_FileName(inputChuoi);
                                System.out.println("Tin nhan tu CLient :" + inputChuoi_ND);
    
                                if(inputChuoi_ND.indexOf(".")!=-1)     
                                {
                                    String inputChuoi_So = inputChuoi_ND.substring(0, inputChuoi_ND.indexOf("."));
                                    ghifile(inputChuoi_So, inputChuoi_fileName);
                                    kqua = tongChuoi(inputChuoi_So);
                                    ghifile(kqua, inputChuoi_fileName);
                                    senData(kqua, socket, clientIP, clientPort);
                                    break;
                                }    
                                else
                                {
                                    kqua = " Ket thuc bang dau 'cham' nha";
                                    senData(kqua, socket, clientIP, clientPort);
                                }
                            } catch (IOException e) {
                                        //TODO: handle exception
                            }
                        }
                        break;
                    default:
                        kqua = "Khong co chuc nang nay";
                    }
                }
            }
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    public static String menu() {
        String menu = "\n\n ========= MENU ==========\n" 
                    + "1. Dao nguoc va luu file\n" 
                    + "2. Xem file\n"
                    + "3. Tinh Tong\n";
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

    public static String docfile(String fileName) throws IOException {

        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String ND_file = "";
        String kqua ="";
        while ((ND_file= br.readLine()) != null) {
            kqua = ND_file;
        }
        return kqua;
    }

    public static String daochuoi(String inputStr) {
        byte[] strAsByteArray = inputStr.getBytes();
        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i < strAsByteArray.length; i++) {
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }

        String Kqua = new String(result);

        return Kqua;
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

    public String daovaghifile(DatagramSocket socket)
    {
        String kqua;
        // Lưu nội dung vào file
        while(true)
        {
            try {
                String inputChuoi = receiveData(socket);
                String inputChuoi_ND = tach_ND(inputChuoi);
                String inputChuoi_fileName = tach_FileName(inputChuoi);

                

                System.out.println("Tin nhan tu CLient :" + inputChuoi_ND);
                        
                ghifile(daochuoi(inputChuoi_ND), inputChuoi_fileName);

                
                if (inputChuoi_ND.equals("HET")) 
                {
                    kqua = "Da ket thuc ghi file " + inputChuoi_fileName;
                    break;
                }
                kqua = "Dao chuoi va ghi file (" + inputChuoi_fileName + ") thanh cong";
            } catch (IOException e) {
                //TODO: handle exception
            }
        }
        return kqua;
    }

    public String tongChuoi (String inputStr)
    {
        int sum = 0;
        for(String w:inputStr.split("\\s",0)){
            sum = sum + Integer.parseInt(w);
        }
        String kqua = "Tong chuoi bang : " + sum;
        return kqua;
    }
}
