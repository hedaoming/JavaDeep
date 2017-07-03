package conrrent.ConPackage;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ipc on 2017/6/26.
 * 通过Condition来实现类似CountDownLatch的功能
 *      在countDown方法中，当count计数为0时，用Condition唤醒主线程
 *      在await方法中，用Condition来使得主线程阻塞等待
 *      注意：Condition需要先通过ReentrantLock拿到锁之后才能使用，类似Object.wait得拿到监视器才能用一样
 */
public class ConditionCountDownDemo implements Runnable{
    //用Condition实现CountDownLatch功能
    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition condition = reentrantLock.newCondition();
    static ConditionCountDown conditionCountDown = new ConditionCountDown(10);
    @Override
    public void run() {
        try{
            conditionCountDown.countDown();
            //Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check over ,count = "+conditionCountDown.getCount());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static class ConditionCountDown{
        //计数器
        int count = 0;
        public ConditionCountDown(int count){
            this.count = count;
        }

        public synchronized void countDown(){
            count--;
            reentrantLock.lock();
            try{
                //线程做完，才signal主线程
                if(count == 0){
                    condition.signal();
                }
            }finally{
                reentrantLock.unlock();
            }
        }
        public synchronized int getCount(){
            return count;
        }
        public void await() throws InterruptedException {
            reentrantLock.lock();
            try{
                //处于等待唤醒状态
                condition.await();
            }finally{
                reentrantLock.unlock();
            }
            //开启另一个线程，使其等待唤醒
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();*/
            /*while(true){
                //线程做完，才signal主线程
                if(count == 0){
                    condition.signal();
                    break;
                }
            }*/

        }
    }

    public static void main(String args[]) throws InterruptedException {
        ConditionCountDownDemo con = new ConditionCountDownDemo();
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i = 0;i<10;i++){exec.submit(con);}
        conditionCountDown.await();
        System.out.println("notify");
        exec.shutdown();
    }

}
