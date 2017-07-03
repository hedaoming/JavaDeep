package jvm.Lock;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ipc on 2017/6/25.
 */
public class LinkedBlockingQueueDemo {
    static LinkedBlockingQueue queue = new LinkedBlockingQueue();

    public static void main(String args[]) throws InterruptedException {
        int[] arr = new int[100];
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<100;i++){
            queue.put(i);
        }
        for(int i=0;i<100;i++){
            arrayList.add(queue.peek());
        }
        System.out.println("peek()"+arrayList.toString());
        for(int i=0;i<100;i++){
            arr[i] = (int) queue.take();
        }
        for(int i=0;i<100;i++){
            System.out.println("take()"+arr[i]);
        }

    }

    class ReadThread implements Runnable{

        @Override
        public void run() {

        }
    }
}
