package Phat_trien_he_thong_tich_hop;

import java.util.Scanner;

public class Doi_Chu_Hoa
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message; 
        System.out.println("\nNhập vào chuỗi cần in hoa : ");
        message = sc.nextLine();
        char[] charArray = message.toCharArray();
        for(int i = 0; i < charArray.length; i++ )
        {
            if(charArray[i] >= 97 && charArray[i] <= 122){
                charArray[i] -= 32;
              }
        }
        message = String.valueOf(charArray);
        System.out.println("Chuỗi sau khi đổi: \n" + message);
    }
}