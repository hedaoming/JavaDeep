package offer.chapter2;

/**
 * Created by ipc on 2017/6/25.
 */
public class ArrayMin {
    public int minNumberInRotateArray(int [] array) {
        if(array!=null||array.length!=0){
            //三个指针
            int pre = 0;
            int mid = pre;
            int last = array.length-1;
            if(array[pre]<array[last]){
                return array[pre];
            }else{
                while(true){
                    //循环结束，前后指针相邻
                    if(last-pre==1){
                        break;
                    }
                    //位于前半部分
                    if(array[mid]<array[pre]){
                        last = mid;
                        mid = (last+pre)/2;

                    }else{
                        //位于后半部分
                        pre = mid;
                        mid = (last+pre)/2;
                    }
                }
                return array[last];
            }
        }else{
            return 0;
        }
    }
}
