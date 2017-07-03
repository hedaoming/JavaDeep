package conrrent.noLock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Created by ipc on 2017/6/13.
 */
public class TestHashMap {
    public static void main(String args[]){
        HashMap<Integer,String> hashMap = new HashMap<Integer,String>();

        hashMap.put(null,"ad");

        //通过key，来计算对应hash，然后找到存储的地方？
        hashMap.put(1,"test");
        //key-》hash-》value
        hashMap.get(1);
        //每次put和remove等增删操作都会修改size值
        hashMap.size();
        //清空是将指向清零？将entry中的value全部设置为null，但是key不用设置为null吗
        hashMap.clear();
        //key和value都是独立存在的，只不过能通过key找到value存放的地址
        //遍历entry？
        hashMap.containsValue("test");
        hashMap.containsKey(1);
        //entry:每一个key-value对应一个entry吗？
        hashMap.put(2,"466");
        //hashMap转换成set有什么用，全部输出？
        Set<Map.Entry<Integer,String>> set= hashMap.entrySet();
       // System.out.println(set.toString());
        //得到所有的key然后再设置到set里面？
        Set<Integer> keySet = hashMap.keySet();
        //为什么不和上面一样设置到set里面？
        Collection<String> values= hashMap.values();
       // System.out.println(keySet.toString()+","+values.toString());
        //通过size来判断？
        hashMap.isEmpty();
        //将对应key设置为null？为什么没有将value remove的方法？
        hashMap.remove(1);

    }
}
