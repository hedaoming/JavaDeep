package classloader;

/**
 * Created by ipc on 2017/5/21.
 */
public class OrderClassLoader extends ClassLoader {
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        // First, check if the class has already been loaded
        Class re=findClass(name);


        if(re == null){
            System.out.println("无法载入此类："+name+"需要请求父加载器");
            return super.loadClass(name,resolve);
        }
        return re;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        Class clazz = this.findLoadedClass(className);
        if (null == clazz) {

        }
        return clazz;
    }
}
