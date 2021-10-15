import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class mulClient {
    public static void main(String[] args) {
        String host = "224.0.0.1";
        int port = 7777;
        try {
            MulticastSocket ms = new MulticastSocket(port);
            ms.joinGroup(InetAddress.getByName(host));

            byte[] buf= new byte[512];
            while(true)
            {
                DatagramPacket nhan = new DatagramPacket(buf, buf.length);
                ms.receive(nhan);

                String str = new String(buf, 0 , buf.length);
                System.out.println("Nhan tu server : " + str);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
