package conrrent.noLock;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by ipc on 2017/6/13.
 */
public class TestAtomicStampedReference {
    static AtomicStampedReference<Integer> asr = new AtomicStampedReference<Integer>(19,0);

    public static void main(String args[]){
        //模拟充值
        for(int i = 0;i<3;i++){
            final int stamped = asr.getStamp();
            new Thread(){
                @Override
                public void run() {
                    while(true){
                        while(true){
                            Integer m = asr.getReference();
                            if(m<20){
                                if(asr.compareAndSet(m,m+20,stamped,stamped-1)){
                                    System.out.println("余额小于20元，充值成功，余额："+asr.getReference()+"元");
                                    break;
                                }
                            }else{
                                System.out.println("余额大于20元，无需充值");
                                break;
                            }
                        }
                    }
                }
            }.start();
        }
        //模拟消费
        new Thread(){
            @Override
            public void run() {
                for(int i = 0;i<100;i++){
                    while(true){
                        int stamped = asr.getStamp();
                        Integer m = asr.getReference();
                        if(m>10){
                            if(asr.compareAndSet(m,m-10,stamped,stamped-1)){
                                System.out.println("消费十元，现在余额："+asr.getReference()+"元");
                                break;
                            }
                        }else{
                            System.out.println("余额不足");
                            break;
                        }
                    }
                    try{
                        Thread.sleep(100);

                    }catch(Exception e){

                    }
                }
            }
        }.start();
    }
}
