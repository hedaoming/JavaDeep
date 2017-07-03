package jvm.collection;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ipc on 2017/6/12.
 * ①测试HashMap线程不安全，以及ConcurrentHashMap线程安全
 *      开启十个线程，对HashMap、ConcurrentHashMap进行并发操作
 *          问题1：虽然最终结果是HashMap的size值没达到预期也就是线程不安全，ConcurrentHashMap线程安全，可是
 *              在操作过程中，两者的size者都会呈现出不同步的状况，分析原因
 *          原因：过程中的size值并不难看出线程安全与否，因为多个线程拿到size之后可能阻塞，此时size值就会停留在之前拿到的值上面，而不是实时值
 *              而最终结果的size才能看出线程安全与否，因为是最终实时值
 *              假设
 *              put(){
 *                  size++;①只有一个线程进来时，能保证size值是安全的，线程安全的
 *                          ②多个线程进来时，会反复操作size的值，不能保证线程安全
 *              }
 *      寻找方法，让HashMap实现线程安全
 *      锁住put语句就可以实现线程安全
 * ②查看HashMap，ConcurrentHashMap，Collections.synchronizedMap源码
 *  1. HashMap和ConcurrentHashMap在put方法上的不同
 *      看不懂：①google代码解释。②重看视频
 *  2. HashMap文档，查看put原理以及key相同时hash会怎么做
 * ③HashMap中：为什么只能用Integer？K和V代表着什么呢？
 *      可拓展泛型及其原理：编译时或运行时
 *   ① T K V E都是泛型通配符，效果是一样的，只不过约定其代表不同类型而已
 *      T 是type
 *      K 是key
 *      V 是value
 *      E 是element
 *   ②  List<T>，List<Object>，List<?>区别
 *      List<?>:集合元素可以是任意类型，这种没有意义，一般是方法中，只是为了说明用法
 *      List<Object> :
 *      T是泛指所有类;
 *
 *
 *3. currentHashMap
 *      1. 线程安全
 *      2. 源码解读
 *          api，线程安全，原理
 */
public class TestConHashMap {
    //test ConcurrentHashMap的api
    public void testConApi(){
        concurrentHashMap.get(1);
        concurrentHashMap.put("two",2);
        concurrentHashMap.elements();
    }

    public static void main(String args[]) throws InterruptedException {

        //测试 HashMap
        Thread[] tHash = new Thread[10];
        for(int i = 0;i<10;i++){
            tHash[i] = new Thread(new HashMapThread(),"HashMapThread"+i);
        }
        for(int k=0;k<10;k++){tHash[k].start();}
        for(int k=0;k<10;k++){tHash[k].join();}
        System.out.println("HashMap size = "+hashMap.size());

        //测试 ConcurrentHashMap
        Thread[] tConcurrent = new Thread[10];
        for(int i = 0;i<10;i++){
            tConcurrent[i] = new Thread(new ConcurrentHashMapThread(),"ConHashMap"+i);
        }
        for(int k=0;k<10;k++){tConcurrent[k].start();}
        for(int k=0;k<10;k++){tConcurrent[k].join();}
        System.out.println("ConcurrentHashMap size = "+concurrentHashMap.size());
    }

    //为什么只能用Integer？K和V代表着什么呢？
    //共享对象
    static HashMap<String,Integer> hashMap = new HashMap<String,Integer>();

    static class HashMapThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0;i<1000;i++){
                /*
                synchronized(this.getClass()){
                    //锁住这句代码，保证线程安全
                    hashMap.put(Thread.currentThread().getName()+i,i);
                    System.out.println(Thread.currentThread().getName()+",size = "+hashMap.size());
                }
                */

                hashMap.put(Thread.currentThread().getName()+i,i);
                //结果为size的原因：i只有一千个，最终为1000时，每个线程都会反复写第一千个i索引下的值，所以size只有1000
                //改变索引为i即可解决这个问题
                System.out.println(Thread.currentThread().getName()+",size = "+hashMap.size());
            }
        }
    }

    static ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<String,Integer>();
    static class ConcurrentHashMapThread implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<1000;i++){
                concurrentHashMap.put(Thread.currentThread().getName()+i,i);
                //System.out.println(Thread.currentThread().getName()+",i = "+concurrentHashMap.get(i)+",size = "+concurrentHashMap.size());
                System.out.println(Thread.currentThread().getName()+",size = "+concurrentHashMap.size());
            }
        }
    }
}
