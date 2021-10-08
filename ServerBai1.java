// package TH_Bai1;

import java.io.*;
import java.net.*;
public class ServerBai1 {
	public static void main (String[] args){
		// Khoi tao  Server Socket
		try{
		ServerSocket ss = new ServerSocket(6430);
		System.out.println("Da khoi tao Server Socket thanh cong!");
		while(true){
			// Chap nhan noi ket tu Client
			try{
			Socket s = ss.accept();
			System.out.println("Co client dia chi"+s.getInetAddress().toString()+", cong"+s.getPort()+ "ket noi den Server!");
			// Khai bao hai stream in-out
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			while(true){
				// Nhan ky tu tu Client
				int ch = is.read();
				if(ch=='@') break;
				// Xu ly va tra ket qua
				String kqua ="";
				switch(ch){
					case '0': kqua = "Khong"; break;
					case '1': kqua = "Mot"; break;
					case '2': kqua = "Hai"; break;
					case '3': kqua = "Ba"; break;
					case '4': kqua = "Bon"; break;
					case '5': kqua = "Nam"; break;
					case '6': kqua = "Sau"; break;
					case '7': kqua = "Bay"; break;
					case '8': kqua = "Tam"; break;
					case '9': kqua = "Chin"; break;
					default: kqua = "Khong phai so nguyen!";
				}
				// Gui tra ket qua sang Client
				os.write(kqua.getBytes());
			}
			System.out.println("Dong noi ket voi Client"+s.getInetAddress().toString()+", cong"+s.getPort());
			s.close();
		}catch (IOException e){System.out.println("Co loi IOException!");};
		}
		}catch(IOException e) {System.out.println("Co loi khi tao Server!");};
    }
}