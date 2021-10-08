

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class wordThread  implements Runnable{
    String ms;
    public wordThread ( String s )
    {
        this.ms = s ;
    }

    public void run()
    {
        System.out.println(Thread.currentThread().getName() + " (Bắt đầu): " + ms);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            //TODO: handle exception
        }
        System.out.println(Thread.currentThread().getName() + "(kết thúc)");
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool(5);

        for ( int i = 0 ; i < 10 ; i++)
        {
            Runnable worker = new wordThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while(!executor.isTerminated())
        {
        }
        System.out.println("Kêt thúc POOL");
    }
}
