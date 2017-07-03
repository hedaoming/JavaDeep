package offer.chapter2;

/**
 * Created by ipc on 2017/6/26.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * 方法描述
 * 出现问题
 * 代码实现
 */
public class BinaryNum {

    public static void main(String args[]){
        int count = new BinaryNum().NumberOf3(10);
        System.out.println(count);
    }


    //数左移：传入数 和 1 做与运算，成立则 +1；负数情况下则不能这样，会陷入死循环：可以避免这样，设置循环次数
    public int NumberOf2(int n){
        int count = 0;
        //八位二进制为一个字节，int 四个字节，32个二进制
        int k = 32;
        if(n<0){
            k = k-1;
        }
        for(int i = 0;i<k;i++){
            //右移时，结果只有0 和 1；所以判断条件可以这样写
            if((n & 1)==1){
                count++;
            }
            n = n >> 1;
        }
        if(n<0){count++;}
        return count;
    }
    //1 右移
    public int NumberOf3(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            //出现问题：为什么这里替换成  (n & flag) == 1就失败了呢？
            //因为左移时，结果并不止1 和 0（图表示）
            if((n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }


    public int NumberOf1(int n) {
        //转换成二进制
        String binary = "";
        if(n>0){
            binary = Integer.toBinaryString(n);
        }else if(n==0){
            return 0;
        }else{
            //负数，用补码表示；负数补码 = 反码 + 1
            String binaryString = Integer.toBinaryString(n);
            char[] chars = binaryString.toCharArray();
            //反码：第一位不变，其他取反
            for(int i = 1;i<8;i++){
                if(chars[i] == '1'){
                    chars[i] = '0';
                }else{
                    chars[i] = '1';
                }
            }
            //难点：最后一位是1的话，会出现很多问题，补码得加1，则很多都得调整了。

        }
        //二进制遍历，记录1的个数
        int count = 0;
        if(!binary.equals("")){
            char[] binaryChar = binary.toCharArray();
            for(int i = 0;i<binaryChar.length;i++){
                if(binaryChar[i]=='1'){
                    count++;
                }
            }
        }
        return count;
    }
}
