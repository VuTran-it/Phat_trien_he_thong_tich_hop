import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(7777);
            System.out.println("UDP SERVER DA DUOC TAO");
            Thread thread = new ServerXuly(socket);
            thread.start();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}