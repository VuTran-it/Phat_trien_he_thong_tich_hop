public class test {
    public static void main(String[] args) {
        String chuoi = "10 70 100";
        int sum = 0;

        for(String w:chuoi.split("\\s",0)){
            System.out.println(w);
            sum = sum + Integer.parseInt(w);
        }

        System.out.println("Tong chuoi bang : " + sum);
    }
}
