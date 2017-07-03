package offer.chapter2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by ipc on 2017/6/14.
 */
public class TestMethod {

    ArrayList arrayList = new ArrayList();
    //栈实现
    Deque stack = new ArrayDeque();
    public ArrayList resort(ListNode listNode){

        while(listNode!=null){
            stack.push(listNode.next);
            listNode = listNode.next;
        }
        while(stack!=null){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}

