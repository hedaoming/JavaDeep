package classloader;

/**
 * Created by ipc on 2017/5/21.
 */
public class FindClassOrder {
    public static void main(String[] args){
        HelloLoader helloLoader = new HelloLoader();
        helloLoader.print();
        ClassLoader loader = helloLoader.getClass().getClassLoader();
        System.out.println(loader.getClass().getSimpleName());
        while(loader.getParent()!=null){
            System.out.println(loader.getClass().getSimpleName());
            loader = loader.getParent();
        }
    }
}
