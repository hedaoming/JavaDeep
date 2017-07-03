package jvm.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ipc on 2017/6/11.
 */
public class SynList {

    //验证Collections中的synichronizedList方法转换之后，是用原先传入的list，还是用自己的list操作
    //eg:Collections.synchronizedList(new ArrayList<Integer>())
    public static void main(String args[]){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        new SynListOne<>(arrayList).add(1);
    }
    static class SynListOne<E>{
        final List<E> list;
        public SynListOne(List<E> list){
            this.list = list;
        }

        public void add(Object o){
            list.add((E) o);
            System.out.println(list.getClass().getSimpleName());
            System.out.println("  ");
        }
    }
}
