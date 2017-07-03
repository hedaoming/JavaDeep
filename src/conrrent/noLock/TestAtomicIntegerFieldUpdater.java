package conrrent.noLock;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by ipc on 2017/6/13.
 */
public class TestAtomicIntegerFieldUpdater {
    public static class English{
        int id;
        volatile int score;
    }
    public final static AtomicIntegerFieldUpdater scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(English.class,"score");
    public static void main(String args[]) throws InterruptedException {
        final English english = new English();
        Thread[] threads = new Thread[10000];
        for(int i = 0;i<10000;i++){
            threads[i] = new Thread(){
                @Override
                public void run() {
                    if(Math.random()>0.4){
                        //传入对象，会自动匹配对象中的字段（通过一开始的指定）
                        scoreUpdater.incrementAndGet(english);
                    }

                }
            };
            threads[i].start();
        }
        for(int i = 0;i<10000;i++){threads[i].join();}
        System.out.println("score:"+english.score);

    }
}
