package offer.chapter2;

/**
 * Created by ipc on 2017/6/25.
 */
public class Fibonacci {
    int num = 0;
    public int fibonacci(int n) {
        //n>=0
        if(n == 1){
            num = 1;
        }else if(n == 0){
            num = 0;
        }else if(n>1){
            num = fibonacci(n-2)+fibonacci(n-1);
        }
        return num;
    }
    public int fibonacciTwo(int n){
        if(n>1){
            return fibonacci(n-2)+fibonacci(n-1);
        }else if(n ==1 ){
            return 1;
        }else if(n == 0){
            return 0;
        }else{
            return 0;
        }
    }

    public static void main(String args[]){
        int i = new Fibonacci().fibonacciTwo(9);
        System.out.println(i);
    }
}
