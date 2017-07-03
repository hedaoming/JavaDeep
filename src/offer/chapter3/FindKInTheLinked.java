package offer.chapter3;

/**
 * Created by ipc on 2017/6/29.
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 解法：采用两个指针
 */
public class FindKInTheLinked {
    public ListNode FindKthToTail(ListNode head,int k) {

        if(head!=null && k>0){
            //两个指针
            ListNode pre = head;
            ListNode last = head;
            //pre到达第 k 的位置
            for(int i =0;i<k-1;i++){
                pre = pre.next;
                //k大于链表长度
                if(pre==null){
                    return null;
                }
            }
            //两个指针一起走，结束条件：pre.next为null，走到了最后一个节点了
            while(pre.next!=null){
                pre = pre.next;
                last = last.next;
            }
            return last;
        }else{
            return null;
        }

    }

    public ListNode test(ListNode head,int k){
        //遍历，得出length
        int length = 0;
        if(head!=null){
            ListNode node = head;
            while(node.next!=null){
                node = node.next;
                length++;
            }
            //再次遍历，返回所需值
            int position = length-k;
            node = head;
            if(position>0){
                for(int i = 0;i<position;i++){
                    node = node.next;
                }
                return node;
            }else{
                return null;
            }

        }else{
            return null;
        }
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
