package offer.chapter2;

import java.util.Stack;

/**
 * Created by ipc on 2017/6/21.
 */
public class DequeueStack {
    //通过两个stack来实现队列：先进先出
    //问题：每次push进之后，如何实现同步在stack中呢
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    //用一个栈存储即可
    public static  void push(int node) {
        stack1.push(node);
    }
    //遍历存储栈，逐个元素pop出来，并push进另一个栈，并pop出最前面一个
    static int flag = 0;

    public static  int pop() {
        //调用了几次pop
        //flag++;
        //每次pop都要清空stack2里面元素
        /*if(!stack2.isEmpty()){
            stack2.clear();
        }*/
        /*int temp = 0;
        int size = stack1.size();
        for(int i = 0;i<size;i++){
            temp = stack1.pop();
            stack2.push(temp);
        }
        int num = 0;*/
        //pop调用了几次，现在请求的值就是第几次的pop了
        /*if(flag<size){
            for(int i = 0;i<flag;i++){*/
                /*num = stack2.pop();
            *//*}
        }*//*

        return num;*/
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }


    public static void main(String args[]){
        //["PSH1","PSH2","PSH3","POP","POP","PSH4","POP","PSH5","POP","POP"]
        push(1);
        push(2);
        push(3);
        int a1 = pop();
        int a2 = pop();
        push(4);
        int a3 = pop();
        push(5);
        int a4 = pop();
        int a5 = pop();
        System.out.println(a1+","+a2+","+a3+","+a4+","+a5);

    }
}
