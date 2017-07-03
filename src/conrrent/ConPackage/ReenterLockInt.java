package conrrent.ConPackage;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ipc on 2017/6/22.
 */
public class ReenterLockInt implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;
    public ReenterLockInt(int lock){
        this.lock = lock;
    }


    @Override
    public void run() {

        try{
            if(lock==1){
                lock1.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch(Exception e){

                }
                lock2.lockInterruptibly();
            }else{
                lock2.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch(Exception e){

                }
                lock1.lockInterruptibly();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }else if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+":线程退出");
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new Thread(new ReenterLockInt(1));
        Thread t2 = new Thread(new ReenterLockInt(2));
        t1.start();t2.start();
        Thread.sleep(1000);
        DeadlockChecker.check();
    }
}
