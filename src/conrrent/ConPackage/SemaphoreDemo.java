package conrrent.ConPackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by ipc on 2017/6/25.
 * ExecutorService是什么？
 * newFixedThreadPool是什么
 * Executors
 */
public class SemaphoreDemo implements Runnable {
    Semaphore semaphore = new Semaphore(5);
    static int i = 0;
    @Override
    public void run() {
        try {
            //什么含义：一个线程获取两个许可
            semaphore.acquire();
            //System.out.println(Thread.currentThread().getId()+"done");
            //Thread.sleep(2000);
            i++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            semaphore.release();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(20);
        final SemaphoreDemo sem = new SemaphoreDemo();
        for(int i = 0;i<20;i++){
            exe.submit(sem);
        }
        Thread.sleep(5000);
        System.out.println(i);
    }
}
