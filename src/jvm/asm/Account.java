package jvm.asm;

/**
 * Created by ipc on 2017/7/3.
 */
public class Account {
    //需要在operation方法执行前嵌入SecurityChecker.checkSerurity()方法
    public void operation(){
        System.out.println("operation...");
    }
    final int num = 0;

}
