package offer.chapter2;

import java.util.ArrayList;

/**
 * Created by ipc on 2017/6/12.
 */
public class ArrayListSolution {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //遍历链表，值存储到ArrayList中
        /*if(listNode!=null){
            arrayList.add(listNode.val);
            for(;;){

            }
        }*/
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (;;){
            if(listNode!=null){
                arrayList.add(listNode.val);
                listNode = listNode.next;
            }else{
                break;
            }
        }
        //从尾到头便能遍历出值了
        /*为什么会没倒转过来？
        int count = 0;
        int temp = 0;
        int size = arrayList.size();
        if(arrayList.size()%2==0){
            count = size;
        }else{
            count = size-1;
        }
        for(int i = 0;i<count;i++){
            temp = arrayList.get(i);
            arrayList.set(i,arrayList.get(size-1-i));
            arrayList.set(size-1-i,temp);
        }*/
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = arrayList.size()-1;i>=0;i--){
            temp.add(arrayList.get(i));
        }
        return temp;


    }
    public ArrayList<Integer> print(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode list = null;
        if(listNode!=null){
            list = listNode;
            while(listNode!=null){
                arrayList.add(listNode.val);
                listNode = listNode.next;
            }
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(arrayList.size()>0){
            for(int i = arrayList.size()-1;i>=0;i--){
                temp.add(arrayList.get(i));
            }
        }

        return temp;
    }
}

class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
}

