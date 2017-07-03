package conrrent.noLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ipc on 2017/6/11.
 * ① AtomicInteger是 如何实现无锁的
 *      用一个for死循环，调用CAS方法，如果成功则退出循环，否则一直循环
 *      1. unsafe有什么用？操作内存，java无法直接操作内存，通过unsafe提供的本地方法来操作内存，实现CAS
 * ②
 */
public class TestAtomicInteger {
    public static void main(String args[]) throws InterruptedException {
        //十个线程来操作
        //ThreadOne[] ts = new ThreadOne[10];
        Thread[] t = new Thread[10];
        for (int j = 0;j<10;j++){
            t[j] = new Thread(new ThreadOne(),"Thread"+j);
        }
        for (int k = 0;k<10;k++){t[k].start();}
        for (int k = 0;k<10;k++){t[k].join();}
        System.out.println("i = "+i);
    }
    AtomicInteger j = null;
    //static AtomicInteger i = new AtomicInteger();
    static int i = 0;
    static class ThreadOne implements Runnable{

        @Override
        public void run() {

            for (int k = 0;k<1000;k++){
                //i.incrementAndGet();
                //i++;线程不安全，i是共享的
                //锁i:常量或者对象才能锁起来

                //i++;
                //锁类Class:这样能保证线程安全
                /*synchronized(ThreadOne.class){
                    i++;
                }*/
                //锁对象：同样不安全，等整个for语句锁起来才有用
                /*synchronized(this){
                    i++;//保证每次只能一个线程能执行这条语句就能保证线程安全
                    System.out.println(Thread.currentThread().getName()+",i = "+i);
                }*/
                //为什么类锁和对象锁结果不一样？
                synchronized(ThreadOne.class){
                    i++;
                    System.out.println(Thread.currentThread().getName()+",i = "+i);
                }
            }
        }
    }
    static class ThreadTwo extends Thread{
        @Override
        public void run() {
            for (int k = 0;k<10000;k++) {
                //锁类Class:这样能保证线程安全
                //每个线程的class字节码是一样的，所以能锁住
                synchronized (ThreadOne.class) {
                    i++;
                }
            }
        }
    }
    static class ThreadThree extends Thread{
        @Override
        public void run() {
            for (int k = 0;k<10000;k++) {
                //锁对象：无法保证线程安全，除非锁for语句
                //每个线程都有个各自的对象，所以都能拿到锁，进来这个语句中，所以锁不住
                synchronized (this) {
                    i++;
                }
            }
        }
    }
}
