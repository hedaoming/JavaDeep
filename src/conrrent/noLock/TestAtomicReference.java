package conrrent.noLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by ipc on 2017/6/12.
 */
public class TestAtomicReference {
    public static void main(String args[]){
        String str = "abc";
        final AtomicReference ar = new AtomicReference();
        ar.set(str);
        for(int i = 0;i<10;i++)
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Math.abs((int) (Math.random() * 100)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(ar.compareAndSet("abc","def")){
                        System.out.println("Thread:"+Thread.currentThread().getId()+"change value");
                    }else{
                        System.out.println("Thread:"+Thread.currentThread().getId()+"failed");
                    }
                }
            }.start();
    }
}
