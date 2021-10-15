import java.io.*;
import java.net.*;

public class Client {
    public static void main (String[] args){
		// Tao ket noi
		try{
		Socket s = new Socket ("127.0.0.1",6789);
		// Khai bao hai stream in-out
		try{
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		while(true){
			byte a[] = new byte[600];
			int m = is.read(a);
			String sms = new String(a,0,m);
			System.out.println(" " + sms);
			// Nhap vao tu ban phim
			int ch = System.in.read();
			System.in.skip(2);
			// Gui ky tu sang Server
			os.write(ch);
			if(ch=='0') break;
			// Nhan ket qua tra ve
			byte b[] = new byte[100];
			int n = is.read(b);
			String kqua = new String(b,0,n);
			System.out.println("Nhan duoc: "+kqua);
		}
		// Dong noi ket
		s.close();
		}catch (UnknownHostException e ) {System.out.println("Co loi UnknownHostException!");};
		}catch (IOException e) {System.out.println("Co loi IOException!");};
		
	}
}
