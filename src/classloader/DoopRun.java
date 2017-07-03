package classloader;

/**
 * Created by ipc on 2017/5/21.
 */
public class DoopRun{
    public static void main(String[] args){
        CVersionA a = new CVersionA();
        while(true){
            a.hello();
        }
    }
}
class CVersionA extends Thread{
    @Override
    public void run(){
        try{
            while(true){
                System.out.println("hello,(version B)");
                sleep(1000);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void hello(){
        System.out.println("version B");
    }
}
