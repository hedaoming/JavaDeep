package conrrent.ConPackage;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ipc on 2017/6/26.
 */
public class CountDownLatchDemo implements Runnable{

    static CountDownLatch end = new CountDownLatch(10);
    static CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {

        try {
            //模拟检查
            Thread.sleep(new Random().nextInt(10)*1000);
            end.countDown();
            System.out.println("check over ,count = "+end.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i = 0;i<10;i++){
            exec.submit(demo);
        }
        //等待其他线程完成
        end.await();
        System.out.println("count数量为 "+end.getCount()+",其他准备工作已完成!");
        exec.shutdown();
    }

}
