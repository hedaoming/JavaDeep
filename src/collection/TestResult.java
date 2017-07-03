package collection;

import java.util.ArrayList;

/**
 * Created by ipc on 2017/6/16.
 * 关键点：全排列和全组合的实现
 */
public class TestResult {
    public void result(int n,int k){
        //编号和为  x%n==0  存储到集合中
        ArrayList list = new ArrayList();
        for (int i = 1 ;i<=n;i++){
            if(i%n==0){
                list.add(i);
            }
        }
        //编号和的总可能，k个数组合起来的所有可能，与contains比较
        int resultSum = 0;

        //输出总可能个数
    }
}
