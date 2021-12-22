
import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalcInterface extends Remote {
    public int[][] TongHaiMaTran(int[][] matran1, int[][] matran2, int rows, int columns) throws RemoteException;

    public int[][] HieuHaiMaTran(int[][] matran1, int[][] matran2, int rows, int columns) throws RemoteException;
}