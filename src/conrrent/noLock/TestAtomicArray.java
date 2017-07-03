package conrrent.noLock;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by ipc on 2017/6/13.
 */
public class TestAtomicArray {
    static int[] arr = new int[10000];
    static AtomicIntegerArray array = new AtomicIntegerArray(10);
    public static void main(String args[]) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i = 0;i<10;i++){
            threads[i] = new Thread(new TestAtomicIntegerArray());
        }
        for(int k = 0;k<10;k++){threads[k].start();}
        for(int k = 0;k<10;k++){threads[k].join();}
        System.out.println(array);
    }
    static class TestAtomicIntegerArray implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<10000;i++){
                array.getAndIncrement(i%array.length());
            }
        }
    }
    static class TestArray implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<100;i++){

            }
        }
    }
}
