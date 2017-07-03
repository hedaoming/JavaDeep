package thread;

/**
 * Created by ipc on 2017/6/26.
 */
public class ExceptionDemo {

    //不抛出异常：异常之后的代码不会运行，当前主线程会退出
    static public void throwsExeOne(){
        int i = 0;
        System.out.println("异常之前");
        i = 4/0;
        System.out.println("异常之后");
    }
    //抛出异常：异常之后的代码不会运行，当前主线程会退出
    static public void throwsExeTwo() throws Exception{
        int i = 0;
        System.out.println("异常之前");
        i = 4/0;
        System.out.println("异常之后");
    }
    //catch住异常：异常之后的代码会运行，主线程也会继续往下执行
    static public void throwsExeThere(){
        int i = 0;
        System.out.println("异常之前");
        try{
            i = 4/0;
        }catch(Exception e){
            System.out.println("异常之后");
        }
        System.out.println("try catch之后的代码");
    }
    public static void throwsExeFour(){
        throwsExeThere();
        System.out.println("four 代码");
    }

    public static void main(String args[]) throws Exception {
        throwsExeFour();
        System.out.println("main");
    }
}
