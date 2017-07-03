package thread;

/**
 * Created by ipc on 2017/5/23.
 */
public class YieldTest {
    public static void main(String args[]) throws InterruptedException {
        //Two two = new Two();
        /**
         * 同一个对象，传递给两个线程
         * 两个不同对象，分别传递给两个线程
         * 这样会导致什么结果？
         */
        /*Thread t1 = new Thread(two);
        Thread t2 = new Thread(two);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("the Thread is stop");*/

        YieldTwo t1 = new YieldTwo("ThreadOne");
        YieldTwo t2 = new YieldTwo("ThreadTwo");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("The Thread is stop");
    }
}

class YieldTwo extends Thread{
    String name;
    public YieldTwo(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for(int i = 0;i<50;i++){
            System.out.println("Name:"+this.name+", i="+i);
            if(i==20){
                Thread.yield();
            }
        }
    }
}
class Two implements Runnable{
    static int i = 0;
    @Override
    public void run() {
        while(true){
            if(i == 10){
                Thread.currentThread().interrupt();
            }
            System.out.println("Name:"+Thread.currentThread().getName()+"i = "+ (++i));
            if(Thread.currentThread().isInterrupted()){
                System.out.println("interrupted");
                break;
            }
            Thread.yield();
        }
    }
}
