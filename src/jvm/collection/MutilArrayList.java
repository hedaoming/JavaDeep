package jvm.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Created by ipc on 2017/6/11.
 * 总结1：线程的共享变量：若是在线程类中的变量则是私有变量不是共享变量，不会造成线程安全问题
 * 总结2：ArrayList是线程不安全的，当多个线程共享这一变量时，会发生问题
 *      功能类似ArrayList而线程安全的类是什么？内部怎么保证线程安全的？
 *      ArrayList中，在add时，会自动添加size（）中的变量吗，让size自动变化？
 *      结果：在ArrayList的add方法中，有一句代码elementData[size++] = e;表示将元素存入其中，且size++会导致size自动+1
 */
public class MutilArrayList {
    //static List<Integer> list = new ArrayList<Integer>();
    //保证线程安全：实质是转换成另一个类
    static List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

    //Vector<Integer> list;
    public static void main(String args[]) throws InterruptedException {
        AddArrayList aone = new AddArrayList(1);
        AddArrayList atow = new AddArrayList(2);
        Thread t1 = new Thread(aone);
        Thread t2 = new Thread(atow);
        t1.start();
        t2.start();
        while(t1.isAlive() || t2.isAlive()) Thread.sleep(1);
        System.out.println("list size:"+list.size());

    }
    static volatile int startNum = 0;
    static class AddArrayList implements Runnable{

        public AddArrayList(int startnum){
            startnum = startNum;
        }

        @Override
        public void run() {
            int count = 0;
            /*synchronized(list){
                while(count<10000){
                    //synchronized(list){
                        list.add(startNum);
                        //startNum+=2;
                    //}
                    //为何startNum不会出现线程安全的问题呢？这语句并不是原子操作，多线程时不是会出现覆盖问题吗？
                    //reason:原本的startNum声明在线程类中，此时每次new线程其实都会重新在栈中分配一个变量，两个线程之间的栈不能相互访问
                    //自然就不会出现线程问题，而把startNum移到主类外面，两个线程共享一个变量则会发现 线程安全问题。
                    startNum+=2;//如何解决这个线程安全问题？把整个while函数锁起来
                    //能不能单纯地锁住stratNUm？好像不行
                    count++;
                }
            }*/
            while(count<10000){
                list.add(startNum);
                startNum +=2;
                count++;
            }

            System.out.println("startNum="+startNum);
            System.out.println("count="+count);
        }
    }
}
