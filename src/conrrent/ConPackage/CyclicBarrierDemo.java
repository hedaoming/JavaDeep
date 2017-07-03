package conrrent.ConPackage;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ipc on 2017/6/30.
 */
public class CyclicBarrierDemo {
    public static class Soldier implements Runnable{

        private String soldier;
        private final CyclicBarrier cyclic;
        Soldier(CyclicBarrier cyclic, String soldierName){
            this.cyclic = cyclic;
            soldier = soldierName;
        }

        @Override
        public void run() {

            try {
                cyclic.await();
                //do something
                dowork();
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void dowork() {
            try {
                Thread.sleep(new Random().nextInt(10)*1000);
                System.out.println(soldier+"任务完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class BarrierRun implements Runnable{

        boolean flag;
        int N;

        BarrierRun(boolean flag,int N){
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {
            if(flag){
                System.out.println("士兵"+N+"个集合完毕");
                flag = false;
            }else{
                System.out.println("士兵"+N+"个任务完成");
            }
        }
    }

    public static void main(String args[]){
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = true;
        //BarrierRun是指定最后一个进入cyclic的线程执行操作
        CyclicBarrier cyclic = new CyclicBarrier(N,new BarrierRun(flag,N));
        System.out.println("集合队伍");
        for(int i = 0;i<N;i++){
            System.out.println("士兵"+i+"报道");
            allSoldier[i] = new Thread(new Soldier(cyclic,"士兵"+N));
            allSoldier[i].start();
            if(i==5){
                allSoldier[i].interrupt();
            }
        }
    }
}
