import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class mulServer {
    public static void main(String[] args) {
        String host = "224.0.0.1";
        int port = 7777;
        try {
            InetAddress addr = InetAddress.getByName(host);
            DatagramSocket ds = new DatagramSocket();
            for(int i = 0 ; i < 100; i ++)
            {
                String msg = "Message number" + i ;
                byte[] data = msg.getBytes();
                
                DatagramPacket pkt = new DatagramPacket(msg.getBytes(), msg.length(),addr,port);
                ds.send(pkt);

                System.out.println("sent: " + msg);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
}
