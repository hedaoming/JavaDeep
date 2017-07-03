package conrrent.ConPackage;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by ipc on 2017/6/30.
 */
public class LockSupportDemo {
    static Object obj = new Object();
    static class ChangeObject extends Thread{
        ChangeObject(String name){
            super.setName(name);
        }
        @Override
        public void run() {
            synchronized(obj){
                System.out.println("进入"+getName()+"准备挂起"+System.currentTimeMillis());
                LockSupport.park();
                System.out.println(getName()+"继续执行"+System.currentTimeMillis());
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ChangeObject t1 = new ChangeObject("t1");
        ChangeObject t2 = new ChangeObject("t2");
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(3000);
        LockSupport.unpark(t1);
        Thread.sleep(3000);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
