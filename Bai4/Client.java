import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap dia chi host");
		String host = sc.nextLine();
		System.out.println("Nhap so port");
		int port = sc.nextInt();
		// Tao ket noi
		try{
			Socket socket = new Socket(host,port);
			System.out.println("Client connecting to server");
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
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
			socket.close();
		}catch (IOException e)
		{System.out.println("Co loi IOException!");};
		
	}
}
