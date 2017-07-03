package offer.chapter2;

import java.util.ArrayList;

/**
 * Created by ipc on 2017/6/17.
 */
public class TestMei {
    //输入n，表示有n个人；输入n个数，表示n个积分
    //除了第一个数之外，全部拿去排序，从下到大

    public int testOne(int n,int[] arr){
        ArrayList<Integer> list = new ArrayList();
        //排序
        for(int j = 1;j<arr.length-1;j++){
            for(int i = 1;i<arr.length-1-i;i++){
                if(arr[i]<arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for(int i = 1;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i];
            arr[arr.length-i] = temp;
        }
        for(int i = 0;i<arr.length;i++){
            list.add(arr[i]);
        }
        //相邻两个数比较，大的添加新建一个ArrayList，添加进里面，但第一个数和另一个相邻值相同时，第一个数胜出
        ArrayList listTwo = new ArrayList();
        //递归，传入ArrayList
        int last = list.get(0);
        m(last,list,listTwo);
        return sum;
    }
    static int sum = 1;
    public void m(int last,ArrayList<Integer> list,ArrayList<Integer> listTwo){
        if(last==list.get(0)){
            for(int i =0;i<list.size()/2;i++){

                    if(list.get(i)>list.get(i+1)){
                        listTwo.add(list.get(i));
                    }else if(list.get(i)==list.get(i+1)){
                        listTwo.add(list.get(i));
                    }else{
                        listTwo.add(list.get(i+1));
                    }
            }
            sum++;
        }
        ArrayList<Integer> listThere = new ArrayList<>();
        this.m(last,listTwo,listThere);
    }

}
