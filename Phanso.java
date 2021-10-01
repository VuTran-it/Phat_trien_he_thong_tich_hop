package Phat_trien_he_thong_tich_hop;

import java.util.Scanner;

public class Phanso{
    float tu;
    float mau;

    public Phanso(float tu, float mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public float getTu() {
        return tu;
    }
 
    public void setTu(float tu) {
        this.tu = tu;
    }
 
    public float getMau() {
        return mau;
    }
 
    public void setMau(float mau) {
        this.mau = mau;
    }

    void inPhanSo()
    {
        System.out.println("Phân Số bạn là : " + tu + "/" + mau);
    }

    void nghichDao()
    {
        float tam;
        tam = tu;
        this.tu = mau;
        this.mau = tam;
        inPhanSo();
    }

    void giaTriThuc()
    {
        float thuc;
        thuc = tu/mau;
        System.out.println("Giá trị thực : " + thuc);
    }

    void congPhanSo(Phanso ps) {
        float ts = this.getTu() * ps.getMau() + ps.getTu() * this.getMau();
        float ms = this.getMau() * ps.getMau();
        Phanso phanSoTong = new Phanso(ts, ms);
        System.out.println("Tổng hai phân số = " + phanSoTong.tu + "/" + phanSoTong.mau);
    }
      
    void truPhanSo(Phanso ps) {
        float ts = this.getTu() * ps.getMau() - ps.getTu() * this.getMau();
        float ms = this.getMau() * ps.getMau();
        Phanso phanSoHieu = new Phanso(ts, ms);
        System.out.println("Hiệu hai phân số = " + phanSoHieu.tu + "/" + phanSoHieu.mau);
    }
     
    void nhanPhanSo(Phanso ps) {
        float ts = this.getTu() * ps.getTu();
        float ms = this.getMau() * ps.getMau();
        Phanso phanSoTich = new Phanso(ts, ms);
        System.out.println("Tích hai phân số = " + phanSoTich.tu + "/" + phanSoTich.mau);
    }
     
    void chiaPhanSo(Phanso ps) {
        float ts = this.getTu() * ps.getMau();
        float ms = this.getMau() * ps.getTu();
        Phanso phanSoThuong = new Phanso(ts, ms);
        System.out.println("Thương hai phân số = " + phanSoThuong.tu + "/" + phanSoThuong.mau);
    }
    public static void main(String[] args) {
        Phanso A = new Phanso(13,4);
        A.inPhanSo();
        A.nghichDao();
        A.giaTriThuc();
        Phanso B = new Phanso(1,4);

        A.congPhanSo(B);
        A.truPhanSo(B);
        A.nhanPhanSo(B);
        A.chiaPhanSo(B);
    }
}
