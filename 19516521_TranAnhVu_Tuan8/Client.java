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

                if(luachon.equals("1")||luachon.equals("2"))
                {
                    System.out.println("Nhap Chuoi :");
                    chuoi = sc.nextLine();
                }

                System.out.println(chucnang.XuLi(luachon, chuoi));
                
                if(luachon.equals("3")) break;
                if(chuoi.equals("exit")) break;
            }

            // Chào trước khi dừng ứng dụng
            String chao ="\n*************************************\n"
                        +"**** Cam On Da Su Dung Ung Dung *****\n"
                        +"****          Mai Yeu <3        *****\n"
                        +"*************************************\n";
            System.out.println(chao);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        
    }
}