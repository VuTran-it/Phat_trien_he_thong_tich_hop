import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChucNang extends Remote {

    public String XuLi(String luachon,String chuoi)throws RemoteException;

    public String menu() throws RemoteException;

    public String DaoChuoi(String input) throws RemoteException;

    public String InHoaChuDau (String input) throws RemoteException;
}