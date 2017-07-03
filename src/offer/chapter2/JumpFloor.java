package offer.chapter2;

/**
 * Created by ipc on 2017/6/26.
 *斐波那契数列
 */
public class JumpFloor {
    /*
    * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    * 分析之后得出：0  1  2  3  5  8  13
    * 除了前三位，其他都符合斐波那契数列，所以采用递归即可。
    * */
    public int jump(int target){
        if(target == 1)
            return 1;
        else if(target == 0)
            return 0;
        else if(target == 2)
            return 2;
        else if(target>1)
            return jump(target -2 )+jump(target-1);
        else
            return 0;
    }
    /*
    *一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    * 用数学归纳法：
    *       f(1) = 1
            f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。
            f(3) = f(3-1) + f(3-2) + f(3-3)
            ....
            f(n-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
            f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) +f(n-1) = f(n-1) + f(n-1)

      可以得出：

      f(n) = 2*f(n-1)
    * */
    public int jumpTwo(int target){
        if(target == 0)
            return 0;
        else if(target == 1)
            return 1;
        else if(target > 1)
            return 2*jumpTwo(target-1);
        else
            return 0;
    }

    /*
    * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    * 但为 n 时
    *       在矩阵最左边横着放：右边剩下的方法为  f(n - 2)
    *       在矩阵最左边竖着放：右边剩下的方法为  f(n - 1)
    *       则为斐波那契数列
    * */
    public int RectCover(int target) {
        if(target == 1)
            return 1;
        else if(target == 2)
            return 2;
        else if(target > 2 )
            return RectCover(target -2)+RectCover(target-1);
        else
            return 0;
    }
}
