package conrrent.ConPackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ipc on 2017/6/22.
 * lock(), 拿不到lock就不罢休，不然线程就一直block。 比较无赖的做法
 * tryLock()，马上返回，拿到lock就返回true，不然返回false。 比较潇洒的做法。    带时间限制的tryLock()，拿不到lock，就等一段时间，超时返回false。比较聪明的做法。
 * lockInterruptibly -> 调用后一直阻塞到获得锁 但是接受中断信号

 */
public class TimeLock {
    public static void main(String args[]){

        /*Thread t1 = new Thread(new LockThread());
        Thread t2 = new Thread(new LockThread());*/
        //TryLockThread t = new TryLockThread();
        LockThread t =  new LockThread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();t2.start();

        //查看是否是公平锁
        lock.isFair();

    }
    static ReentrantLock lock = new ReentrantLock();
    //公平锁
    ReentrantLock fairLock = new ReentrantLock(true);
    static class LockThread implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try{
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("unlock");
            }
        }
    }
    static class TryLockThread implements Runnable{

        @Override
        public void run() {
            try{
                if(lock.tryLock(5, TimeUnit.SECONDS)){
                    Thread.sleep(6000);
                }else{
                    System.out.println(Thread.currentThread().getName()+": get lock failed");
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }
        }
    }
    static class LockInterruptibly implements Runnable{

        @Override
        public void run() {

        }
    }

}
