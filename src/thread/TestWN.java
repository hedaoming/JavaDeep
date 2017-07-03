package thread;

/**
 * Created by ipc on 2017/6/7.
 */
public class TestWN {
    public static void main(String args[]){
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();

    }
    final static Object object = new Object();

    static class T1 extends Thread{
        @Override
        public void run(){
            System.out.println("T1 start");
            synchronized(object){
                System.out.println("T1 wait");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 end");
            }
            System.out.println("T1 last end");
        }
    }

    static class T2 extends Thread{
        @Override
        public void run() {
            System.out.println("T2 start");
            synchronized(object){
                System.out.println("T2 notify T1");
                object.notify();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2 end");
            }
        }
    }
}
