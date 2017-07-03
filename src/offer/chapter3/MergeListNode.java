package offer.chapter3;

/**
 * Created by ipc on 2017/7/1.
 */
public class MergeListNode {
    //递归形式
    public ListNode Merge(ListNode list1,ListNode list2) {
        //list1 null
        if(list1==null){
            //list 2 null
            if(list2==null){
                return null;
            }
            return list2;
        }else if(list2==null){
            return list1;
        }

        if(list1.val>list2.val){
            list2.next = Merge(list1,list2.next);
            return list2;
        }else{
            list1.next =Merge(list1.next,list2);
            return list1;
        }
    }
    //遍历形式
    public ListNode MergeAnother(ListNode list1,ListNode list2){
        if(list1==null){
            if(list2==null){
                return null;
            }
            return list2;
        }else if(list2==null){
            return list1;
        }

        boolean returnList1 = true;
        if(list1.val>list2.val){
            returnList1 = false;
        }

        ListNode list1Pre = list1;
        ListNode list1Next = list1Pre.next;
        ListNode list2Pre = list2;
        ListNode list2Next = list2Pre.next;
        while(list1Pre!=null && list2Pre!=null){
            if(list1Pre.val<list2Pre.val){
                list1Pre.next = list2Pre;
                list1Pre = list1Next;
                list1Next = list1Pre.next;
            }else{
                list2Pre.next = list1Pre;
                list2Pre = list2Next;
                list2Next = list2Pre.next;
            }
        }
        if(returnList1){
            return list1;
        }else{
            return list2;
        }
    }
}
