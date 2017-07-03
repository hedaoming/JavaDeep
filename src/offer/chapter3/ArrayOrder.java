package offer.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ipc on 2017/6/29.
 */
public class ArrayOrder {

    public static void main(String args[]){
        int[] temp = new ArrayOrder().reOrderArray(new int[]{1,2,3,4,5,6,7});
        for(int i=0;i<temp.length;i++){
            System.out.println(temp[i]);
        }
    }
    public int[] reOrderArray(int[] arr){
        List<Integer> list = new ArrayList<Integer>();
        //arr null
        if(arr!=null){
            //遍历数组，奇数添加到list
            for(int i =0;i<arr.length;i++){
                if(arr[i]%2!=0){
                    list.add(arr[i]);
                }
            }
            //再次遍历数组，偶数添加到list
            for(int i =0;i<arr.length;i++){
                if(arr[i]%2==0){
                    list.add(arr[i]);
                }
            }
            int[] temp = new int[list.size()];
            for(int i = 0;i<list.size();i++){
                temp[i] = list.get(i);
            }

            return temp;
        }else{
            return null;
        }
    }
}
