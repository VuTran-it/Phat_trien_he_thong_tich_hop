import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws NotBoundException {
        Registry reg;
        try {
            reg = LocateRegistry.getRegistry(6060);
            CalcInterface cItf = (CalcInterface) reg.lookup("VuTran");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap so dong cua ma tran : ");
            int rows = scanner.nextInt();

            System.out.println("Nhap so cot cua ma tran : ");
            int columns = scanner.nextInt();

            int[][] matrix1 = new int[rows][columns];
            int[][] matrix2 = new int[rows][columns];

            System.out.println("Nhap ma tran 1:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            System.out.println("\nMa Tran 1 : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix1[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Nhap ma tran 2:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix2[i][j] = scanner.nextInt();
                }
            }

            System.out.println("\nMa Tran 2 : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix2[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("\nTong hai ma tran : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(cItf.TongHaiMaTran(matrix1, matrix2, rows, columns)[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("\nHieu hai ma tran : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(cItf.HieuHaiMaTran(matrix1, matrix2, rows, columns)[i][j] + " ");
                }
                System.out.println();
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}