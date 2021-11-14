import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ChucNang_Implement extends UnicastRemoteObject implements ChucNang {

    protected ChucNang_Implement() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    public String XuLi(String luachon,String chuoi)
    {
        String kqua = "";
        switch(luachon)
        {
            case "1":
                if(chuoi.equals("exit")) break;
                kqua = "\nKet qua nhan duoc : " + InHoaChuDau(chuoi);
                break;
            case "2":
                if(chuoi.equals("exit")) break;
                kqua = "\nKet qua nhan duoc : " + DaoChuoi(chuoi);
                break;
            case "3":
                break;
            case "exit":
                break;
            default:
                String loi = "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n"
                                +"!!!!!    KHONG CO CHUC NANG NAY    !!!!!\n"
                                +"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n";
                kqua = loi ;
        }     
        return kqua;           
    }

    public String menu()
    {
        String menu = "\n\n ========= MENU ==========\n" 
        + "1. In hoa chu cai dau\n" 
        + "2. Dao chuoi\n"
        + "3. Thoat\n";
        return menu;
    }

    public String InHoaChuDau (String input)
    {
        char[] charArray = input.toCharArray();
        boolean foundSpace = true;
        for(int i = 0; i < charArray.length; i++) {
            if(Character.isLetter(charArray[i])) {
                if(foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            }
            else {
                foundSpace = true;
            }
        }
        input = String.valueOf(charArray);
        return input;
    }

    public String DaoChuoi(String input) {
        byte[] strAsByteArray = input.getBytes();
        byte[] result = new byte[strAsByteArray.length];
        for (int i = 0; i < strAsByteArray.length; i++)
        {
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }
        String kqua = new String(result);
        return kqua;
    }
}