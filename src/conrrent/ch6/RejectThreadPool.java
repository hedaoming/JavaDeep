package conrrent.ch6;

import java.util.concurrent.*;

/**
 * Created by ipc on 2017/7/13.
 */
public class RejectThreadPool {
    class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+" ,Thread id:"+Thread.currentThread().getId());
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(System.currentTimeMillis()+","+Thread.currentThread().getId()+"is discard");
                    }
                });
        for(int i = 0;i<200;i++){
            pool.submit(new RejectThreadPool().new Task());
            Thread.sleep(10);
        }
    }
}
