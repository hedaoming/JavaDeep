package jvm.collection;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by ipc on 2017/6/16.
 * 1. 了解hashtable的api
 *      继承Dictionary，elements方法就是Dictionary的
 * 2. 测试hashtable线程安全，与hashmap做比较
 * 3. 查看hashtable的源码
 *  ①内部的结构是怎么样的呢？
 *  ②内部维护了一个什么来保存键值数据（原理图）
 *  ③冲突碰撞时，会如何抉择？和HashMap一样用链表来维护
 *  ④允许空键吗？不允许null键和null值
 *  ⑤fast-failed机制
 *  ⑥transient 关键字有什么用
 */
public class TestHashtable {
    public static void main(String arsg[]){

    }
    public void test(){
        Hashtable<Integer,String> hashtable = new Hashtable<Integer,String>();
        //hashtable的api有些像vector，都能添加Object对象引用
        hashtable.put(1,"one");
        hashtable.get(1);

        hashtable.remove(1);
        hashtable.size();





        HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
        hashMap.isEmpty();
    }
}
