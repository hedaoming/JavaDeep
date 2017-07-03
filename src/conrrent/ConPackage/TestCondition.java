package conrrent.ConPackage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ipc on 2017/6/25.
 */
public class TestCondition implements Runnable{
    //condition和ReentrantLock配套使用
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition condition = reentrantLock.newCondition();


    @Override
    public void run() {
        reentrantLock.lock();
        try{
            System.out.println("进入等待await");
            condition.await();
            System.out.println("唤醒notify");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            reentrantLock.unlock();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        TestCondition t = new TestCondition();
        Thread thread = new Thread(t);
        thread.start();
        Thread.sleep(3000);
        //主线程要拿到ReentrantLock，当成Monitor
        reentrantLock.lock();
        condition.signal();
        reentrantLock.unlock();
    }
}
