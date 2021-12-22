import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcImplement extends UnicastRemoteObject implements CalcInterface {

    protected CalcImplement() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    public int[][] TongHaiMaTran(int[][] matran1, int[][] matran2, int rows, int columns) {
        int[][] resultMatix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatix[i][j] = matran1[i][j] + matran2[i][j];
            }
        }
        return resultMatix;
    }

    public int[][] HieuHaiMaTran(int[][] matran1, int[][] matran2, int rows, int columns) {
        int[][] resultMatix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
               for (int j = 0; j < columns; j++) {
                     resultMatix[i][j] = matran1[i][j] - matran2[i][j];
               }
        }
        return resultMatix;
    }
}