package conrrent.ch6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ipc on 2017/7/13.
 */
public class ThreadPoolDemo {
    class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+" ,Thread id:"+Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        ExecutorService exe = Executors.newFixedThreadPool(5);

        for(int i = 0;i<10;i++){
            exe.submit(new Thread(new ThreadPoolDemo().new Task()));
        }
    }
}
