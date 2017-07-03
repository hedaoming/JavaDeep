package conrrent.ConPackage;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ipc on 2017/6/22.
 * 问题：
 *      可重入锁的原理是什么
 *      获取两次锁之后的原理是什么？为什么能获取两次
 */
public class TestReentrantLock {
    static ReentrantLock reentrantLock = new ReentrantLock();
    static int j = 0;
    static class ReentThreadTwo implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<10000;i++){
                reentrantLock.lock();
                reentrantLock.lock();
                try{
                    j++;
                }finally{
                    reentrantLock.unlock();
                    //reentrantLock.unlock();
                }
            }
        }
    }
    static class ReentThread implements Runnable{
        @Override
        public void run() {
            /*for(int i= 0;i<10000;i++){
                reentrantLock.lock();
                try{
                    j++;
                }finally{
                    reentrantLock.unlock();
                }
            }*/
            reentrantLock.lock();
            try{
                for(int i= 0;i<10000;i++){
                    j++;
                }
            }finally{
                reentrantLock.unlock();
            }
        }
    }
    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(new ReentThreadTwo());
        Thread t2 = new Thread(new ReentThreadTwo());
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(j);
    }
}
