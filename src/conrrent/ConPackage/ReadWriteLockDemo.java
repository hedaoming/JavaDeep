package conrrent.ConPackage;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ipc on 2017/6/25.
 * 没有读写锁：
 *      十个线程同时读，十个线程同时写；
 *      此时会出现线程不安全问题，在读的同时进行写，自然就会发生不同步的问题了。
 * 有读写锁：
 *      十个线程读，十个线程写；
 *      此时读线程运行时，不会让写线程运行，这样就不会发生问题了
 *原理：都是由AQS来实现，具体暂时还不明，得补充AQS
 */
public class ReadWriteLockDemo {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.ReadLock readLock = null;
    static ReentrantReadWriteLock.WriteLock writeLock = null;
    public static void getLock(){
        readLock = lock.readLock();
        writeLock = lock.writeLock();
    }

    static int i = 0;
    //写线程，在写时，读锁应是无法获得的
    static class ReadThread implements Runnable{

        @Override
        public void run() {
            readLock.lock();
            try{
                for(int j = 0;j<100;j++){
                    System.out.println(Thread.currentThread().getId()+",ReadLock"+i);
                    //i++;
                }
            }finally {
                readLock.unlock();
            }
        }
    }

    static class WriteThread implements Runnable{

        @Override
        public void run() {
            writeLock.lock();
            try{
                for(int j = 0;j<100;j++){
                    System.out.println(Thread.currentThread().getId()+",WriteLock"+i);
                    i++;
                }
            }finally{
               writeLock.unlock();
            }
        }
    }

    public static void main(String args[]){
        getLock();
        Thread[] readThreads = new Thread[10];
        Thread[] writeThreads = new Thread[10];
        for(int k = 0;k<10;k++){
            readThreads[k] = new Thread(new ReadThread());
            writeThreads[k] = new Thread(new WriteThread());
        }
        //读写同时存在，会发生阻塞：每次只能有一个线程写完，才能有一个线程去读取
        for(int k = 0;k<10;k++){readThreads[k].start();writeThreads[k].start();}
        //只有读锁，不会阻塞,多个线程能同时读取数据
        //for(int k = 0;k<10;k++){readThreads[k].start();}
    }
}
