package offer.chapter3;

/**
 * Created by ipc on 2017/6/29.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 思路：三个指针来实现，依次对每个节点进行反转next，第三个指针存储还未改变next之前的节点
 * 考虑因素：链表为null，链表只有一个元素，链表只有两个元素：容易因为三个指针引起空指针，例如 pre，mid = null,last = mid.next(mid为null，异常)
 *
 */
public class ReverseLinkNode {
    public ListNode ReverseList(ListNode head) {
        if(head!=null){
            ListNode pre = head;
            ListNode mid = pre.next;
            ListNode last;
            //元素只有一个
            if(mid==null){
                return pre;
            }else if(mid.next==null) {
                //元素只有两个
                mid.next = pre;
                pre.next = null;
                return mid;
            }else{
                //元素有三个及以上
                last = mid.next;
                boolean flag = true;
                while(mid!=null){
                    mid.next = pre;
                    //第一个pre，next指向null
                    if(flag){
                        pre.next = null;
                        flag = false;
                    }

                    pre = mid;
                    //last存储未改变之前的mid.next
                    mid = last;
                    //防止空指针异常
                    if(mid!=null){
                        last = mid.next;
                    }
                }
                return pre;
            }
        }else{
            return null;
        }
    }
}
