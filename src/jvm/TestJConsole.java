package jvm;

/**
 * Created by ipc on 2017/6/7.
 */
public class TestJConsole {
    public static void main(String args[]) throws Exception{
        new TestJConsole().say();
    }

    void say() throws Exception{
        System.out.println("start");
        Thread.sleep(3000);
        System.out.println("end");
    }
}
