package offer.chapter4;
import java.util.Stack;
/**
 * Created by ipc on 2017/7/4.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 * 思路：
 *      一个是储存栈，一个是辅助栈
 *      每次压入栈时，都判断是否比辅助栈第一个数字小，是则压入辅助栈
 */
public class StackMin {
    Stack<Integer> stackOrigin = new Stack<Integer>();
    Stack<Integer> stackAssist = new Stack<Integer>();
    //每次push则比较与辅助栈栈顶数值的大小，如果大于辅助栈则不用做处理，小于则要压如辅助栈
    public void push(int node) {
        //不是第一次push
        if(!stackAssist.empty()){
            int minNum = stackAssist.pop();
            if(minNum>node){
                stackAssist.push(minNum);
                stackAssist.push(node);
            }else{
                stackAssist.push(minNum);
            }
            stackOrigin.push(node);
        }else{
            //第一次push
            stackOrigin.push(node);
            stackAssist.push(node);
        }
    }
    //每次pop都要确认是否是辅助栈栈顶的值，如果是则移除辅助栈栈顶
    public void pop() {
        if(!stackOrigin.empty()){
            int originNum = stackOrigin.pop();
            int minNum = stackAssist.pop();
            //不等则压入之前弹出的最小值
            if(originNum!=minNum){
                stackAssist.push(minNum);
            }
        }

    }

    public int top() {
        int originNum = stackOrigin.pop();
        stackOrigin.push(originNum);
        return originNum;
    }

    public int min() {
        int minNum = stackAssist.pop();
        //防止每次使用min()函数都会丢失栈顶最小值
        stackAssist.push(minNum);
        return minNum;
    }
}
