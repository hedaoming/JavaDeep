package conrrent.ch6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ipc on 2017/7/13.
 */
public class ExtThreadPool {
    class Task implements Runnable{
        String name;
        public Task(String name){
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("正在执行，线程ID:"+Thread.currentThread().getId()+"，name = "+name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5,5,0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行"+Thread.currentThread().getName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("结束执行"+Thread.currentThread().getName());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };
        for(int i =0;i<10;i++){
            es.submit(new ExtThreadPool().new Task("线程"+i));
            Thread.sleep(10);
        }
        es.shutdown();
    }
}
