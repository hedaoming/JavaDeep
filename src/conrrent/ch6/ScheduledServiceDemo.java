package conrrent.ch6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ipc on 2017/7/13.
 */
public class ScheduledServiceDemo {
    public static void main(String args[]){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        //前面任务执行完，才会执行接下去的任务
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis()+",Thread id:"+Thread.currentThread().getId());
                try {
                    Thread.sleep(2000);//每个任务睡眠两秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2,TimeUnit.SECONDS);//每隔两秒调度一个任务
    }

    /*public static void main(String[] args) {
        ScheduledExecutorService ses= Executors.newScheduledThreadPool(2);
        //如果前面的任务没有完成，则调度也不会启动
        ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis()/1000+", Thread id:"+Thread.currentThread().getId());
//                    if(System.currentTimeMillis()%2==0){
//                    	System.out.println("exception");
//                    	throw new RuntimeException();
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);

    }*/
}
