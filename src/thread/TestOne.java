package thread;

/**
 * Created by ipc on 2017/5/23.
 */
public class TestOne {
    public static void main(String[] args) throws InterruptedException {
        One t1 = new One();
        One t2 = new One();
        t1.start();
        t2.start();
        boolean alive = t1.isAlive();
        System.out.println("Is't alive?"+alive);
        t1.join();
        t2.join();
        alive = t1.isAlive();
        System.out.println("Is't alive?"+alive);
        System.out.println("t1 t2 end!");
    }
    static synchronized void no(){

    }
}
class One extends Thread{
    static int i = 0;
    @Override
    public void run() {
        i++;
        System.out.println("new Thread,i="+i);
    }
}