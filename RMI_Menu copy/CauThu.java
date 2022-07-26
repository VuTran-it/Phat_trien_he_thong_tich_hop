import java.io.Serializable;
 

public class CauThu implements Serializable {
    private int maCT;
    private String ten;
    private int namSinh;
    private String viTriThiDau;
    private float luongCoBan;
 
    public CauThu() {
    }
 
    public CauThu(int maCT, String ten, int namSinh, String viTriThiDau, float luongCoBan) {
        super();
        this.maCT = maCT;
        this.ten = ten;
        this.namSinh = namSinh;
        this.viTriThiDau = viTriThiDau;
        this.luongCoBan = luongCoBan;
    }
 
    public int getMaCT() {
        return maCT;
    }
 
    public void setMaCT(int id) {
        this.maCT = maCT;
    }
 
    public String getTen() {
        return ten;
    }
 
    public void setTen(String ten) {
        this.ten = ten;
    }
 
    public int getNamSinh() {
        return namSinh;
    }
 
    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
 
    public String getViTriThiDau() {
        return viTriThiDau;
    }
 
    public void setViTriThiDau(String viTriThiDau) {
        this.viTriThiDau = viTriThiDau;
    }
 
    public float getLuongCoBan() {
        return luongCoBan;
    }
 
    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
}