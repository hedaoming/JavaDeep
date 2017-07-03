package thread;

/**
 * Created by ipc on 2017/6/7.
 */
public class homework1 {
    // 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
    public static void main(String args[]) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        
    }

    static class T1 extends Thread{
        @Override
        public void run() {
            System.out.println("i am T1");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class T2 extends Thread{
        @Override
        public void run() {
            System.out.println("i am T2");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class T3 extends Thread{
        @Override
        public void run() {
            System.out.println("i am T3");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
