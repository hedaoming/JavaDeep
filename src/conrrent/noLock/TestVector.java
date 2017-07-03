package conrrent.noLock;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by ipc on 2017/6/15.
 * 目的：
 *      1. 了解Vector的api
 *      2. 查看Vector的源码
 *          ①未指定容量时，初始容量是10
 *              1. 容量达上限时，扩容会修改整个数组吗？比如将整个数组元素都移动到另一个数组中
 *                  扩容会修改整个数组，调用Arrays.copyOf方法，而Arrays.copyOf方法内部又会调用System.arraycopy()
 *                  而System.arraycopy()中就是创建一个新的数组，然后将元素都复制过去，最终返回新数组的引用。
 *              2. 元素达到容量上限
 *                  1. 验证是否有指定capacityIncrement，
 *                      若有则新容量为 旧容量+capacityIncrement
 *                      若没有则新容量为  旧容量+旧容量，即是旧容量的两倍
 *          ②elementData,elementCount是单纯值存入的element吗？还是普通元素也是在内的？
 *              代码查看结果：普通元素也包含在内，所以Vector是内部维护一个数组来实现的
 *          ③remove中的System.arraycopy详解
 *          System.arraycopy(elementData,   index+1,        elementData,    index,                  numMoved);
 *                              源数组     源数组起始位置       目标数组       目标数组放置的起始位置       复制的长度
 *                              表示elementData的前部分不修改，从index开始的部分用index+1到长度这部分代替（画图易理解）
 *          所以这个方法能实现数组的部分复制，全部赋值等
 *      3. 尝试写无锁的Vector
 *
 * 补充：
 *      1. 验证Vector的线程安全，和ArrayList比较
 *      2. 了解ArrayList的api
 *      3. 查看ArrayList的源码以及实现原理
 *          ①内部数据结构实现
 *              elementData数组
 *          ②容量如何增加
 *          ③初始容量10
 *      4. 查看LinkedList的api，源码，原理
 */
public class TestVector {
    public static void main(String args[]){
       // testArrayList();
        //左移
        int a = 8;
        int a1 = a>>3;
        //右移
        int a2 = a<<3;
        System.out.println("a = "+a+",a1 = "+a1+",a2 = "+a2);//a = 2,a1 = 1,a2 = 4

    }
    //ArrayList API
    public static void testArrayList(){
        list.add(1);
        for(int i = 0;i<8;i++){list.add(i+2);}
        list.add(10);
        list.add(11);
        list.remove(1);
        list.set(1,1);
        list.size();
        list.get(1);
        list.listIterator();
        list.subList(3,5);
    }
    public static void testThread() throws InterruptedException {
        Thread[] threads =new Thread[100];
        for(int i = 0;i<100;i++){
            //threads[i] = new Thread(new VectorThread());
            threads[i] = new Thread(new ArrayListThread());
        }
        for(int i = 0;i<100;i++){threads[i].start();}
        for(int i = 0;i<100;i++){threads[i].join();}
//        System.out.println("size = "+v.size());
        System.out.println("size = "+list.size());
    }
    static Vector v = new Vector();
    static class VectorThread implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<1000;i++){
                v.add(i);
            }
        }
    }
    static ArrayList list = new ArrayList();
    static class ArrayListThread implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<100;i++){list.add(i);}
        }
    }
    public void testApi(){
        //1. 了解Vector的api
        Vector vector = new Vector();
        //vector实质也和ArrayList一样，通过数组来实现
        vector.add(1);//数组元素赋值，下标+1，会验证是否需要扩容
        vector.addElement(new int[]{2,3,4});//可存储对象；难道是存储对象的地址吗？存储的是对象的引用吧
        vector.get(0);//通过下标得到对应数组元素的值

        //vector.set(3,3);//下标为3的数组元素的值被覆盖
        vector.size();//内部维护一个elementCount变量，add，remove等操作时，会修改该变量
        vector.capacity();//what different between capacity and size；可以指定容量，此时容量就是vector大小，size是里面有的元素个数

        System.out.println(vector.toString()+","+vector.size());//1  2  3  3
        vector.remove(0);//遍历index之后的数组，将其值逐个往前挪一位覆盖
        System.out.println(vector.toString()+","+vector.size());//2  3  3

        vector.elements();//遍历数组，返回其内是对象引用的元素

        vector.toArray();//返回内部维护的数组
    }
}
