package Phat_trien_he_thong_tich_hop;

import java.util.Scanner;

public class Point {
    float x ; 
    float y;

    void toaDo(float x , float y )
    {
        this.x = x;
        this.y = y;
    }

    void nhapDiem()
    {
        float hoanhDo, tungDo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tọa độ của bạn : ");
        hoanhDo = sc.nextFloat();
        tungDo = sc.nextFloat();
        toaDo(hoanhDo, tungDo);
    }

    void inDiem()
    {
        System.out.println("Toa độ bạn nhập là  : (" + x + ","+y+")");
    }

    void khoangCachToiTam()
    {
        double kc;
        kc=Math.sqrt((x*x)+(y*y));
        System.out.println("Khoang cách tới tâm là : "+ kc);
    }

    public static void main(String[] args) {
        Point A = new Point();
        A.nhapDiem();
        A.inDiem();
        A.khoangCachToiTam();
    }
}
