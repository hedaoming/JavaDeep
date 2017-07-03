package offer.chapter3;

/**
 * Created by ipc on 2017/6/28.
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 需要考虑的是数值的多种可能，以及多种可能搭配多种运算会出现的结果，比如0 负数  正数；比如 除法  倒数  指数等
 */
public class DoubleNumPower {

    public static void main(String args[]){
        new DoubleNumPower().Power(2,-3);
    }

    public double Power(double base, int exponent) {

        double result = 0;
        //base  = 0,负数，正数
        if(base == 0){
            return 0;
        }else{
            //exponent = 0,负数，正数
            if(exponent == 0){
                result = 1;
            }else if(exponent>0){
                result = base;
                for(int i = 1;i<exponent;i++)
                    result = result * base;

            }else{
                //exponent 取绝对值
                exponent = -exponent;
                result = base;
                for(int i = 1;i<exponent;i++)
                    result = result * base;
                result = 1/result;
            }
        }

        return result;
    }
}

