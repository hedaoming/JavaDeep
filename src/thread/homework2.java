package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ipc on 2017/6/7.
 */
public class homework2 {
    static Q q = new Q();
    //final static Object object = new Object();
    public static void main(String args[]) throws InterruptedException {

        T1 t1 = new T1();
        t1.start();
        Thread.sleep(3000);
        T2 t2 = new T2();
        t2.start();
        Thread.sleep(3000);
        T3 t3 = new T3();
        t3.start();
        Thread.sleep(3000);
        T1 t11 = new T1();
        t11.start();
    }
    static class T1 extends Thread{
        @Override
        public void run() {
            try {
                q.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class T2 extends Thread{
        @Override
        public void run() {

            try {
                q.add(0);
                q.add(1);
                q.add(2);
                q.add(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class T3 extends Thread{
        @Override
        public void run() {
            if(list.size()==3){
                list.clear();
                synchronized(list){
                    list.notify();
                }
            }
        }
    }
    static List<Integer> list = new ArrayList<Integer>();
    //队列必须是线程安全的
    static class Q{

        //如果add时，队列已经满，则add线程要等待，直到队列有空闲空间。
        public void add(int value) throws InterruptedException {
            //队列满
            if(list.size()==3){
                System.out.println("队列已满");
                //锁对象为需要操作的对象
                synchronized(list){
                    list.wait();
                    list.add(value);
                    list.notify();
                }

            }else{
                list.add(value);
                synchronized (list){
                    list.notify();
                }
            }
        }
        //如果get执行时，队列为空，线程必须阻塞等待，直到有队列有数据
        public int get() throws InterruptedException {
            if (list.isEmpty()) {
                synchronized(list){
                    System.out.println("list空，阻塞等待");
                    list.wait();
                }
            }
            System.out.println("get:"+list.get(0));
            return list.get(0);
        }
    }
}
