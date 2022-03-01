import java.rmi.*;
import java.rmi.registry.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws NotBoundException {
        Registry reg;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhan port (Nhap sai 5 lan se thoat):");
            // Xử lý lỗi trôi lệnh
            int port = Integer.parseInt(sc.nextLine());
            // Màu mè thêm hihihi
            boolean check = true;
            for(int i = 0; i < 4;i++)
            {
                if(port != 8888)
                {
                    System.out.println("Xin Nhap Lai Port : ");
                    port = Integer.parseInt(sc.nextLine());
                    check = false;
                }
                else
                {
                    check = true;
                    break;
                }
            }
            // 5 Lần sai sẽ dừng chương trình
            if(check == false) System.exit(0);

            reg = LocateRegistry.getRegistry(port);
            ChucNang chucnang = (ChucNang) reg.lookup("VuTran");

            while(true)
            {   
                System.out.println(chucnang.menu()); 
                System.out.println("Nhap lua chon");
                String luachon = sc.nextLine();
                String chuoi = "";
                switch(luachon)
                {
                    case "1":
                        chuoi = nhapChuoi();
                        if(chuoi.equals("exit")) break;
                        System.out.println("\nKet qua nhan duoc : " + chucnang.InHoaChuDau(chuoi));
                        break;
                    case "2":
                        chuoi = nhapChuoi();
                        if(chuoi.equals("exit")) break;
                        System.out.println("\nKet qua nhan duoc : " + chucnang.DaoChuoi(chuoi));
                        break;
                    case "3":
                        break;
                    case "exit":
                        break;
                    default:
                        String loi = "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
                                        +"!!!!!    KHONG CO CHUC NANG NAY    !!!!!\n"
                                        +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
                        System.out.println(loi);
                }

                if(luachon.equals("3")) break;
                if(chuoi.equals("exit")) break;
            }
            String chao ="\n*************************************\n"
                        +"**** Cam On Da Su Dung Ung Dung *****\n"
                        +"****          Mai Yeu <3        *****\n"
                        +"*************************************\n";
            System.out.println(chao);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        
    }

    public static String nhapChuoi()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi :");
        String str = sc.nextLine();
        return str;
    }
}