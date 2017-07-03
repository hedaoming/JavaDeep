package jvm.collection;

import java.io.*;

/**
 * Created by ipc on 2017/6/24.
 */
public class TestTransient {
    public static void write(Object obj) throws IOException {
        //输出流
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:/Users/ipc/Desktop/user.txt"));
        //写出对象
        outputStream.writeObject(obj);
        //关闭流
        outputStream.close();
    }
    public static Object read(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Object obj = inputStream.readObject();
        inputStream.close();
        return obj;
    }

    public static void main(String args[]){
        /*try {
            write(new User("Amy","123",001));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("write wrong");
        }
        try {
            User user = read("C:/Users/ipc/Desktop/user.txt");
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("read wrong");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("read wrong");
        }
*/


        try {
            write(new Customer("Amny","123",1));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("write wrong");
        }
        try {
            Customer customer = (Customer) read("C:/Users/ipc/Desktop/user.txt");
            System.out.println(customer);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("read wrong");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("read wrong");
        }

    }
}

class User implements Serializable{
    private String userName;
    //序列化时，不保存到硬盘中
    private transient String pwd;
    private static int id;
    public User(String name,String pwd,int id){
        userName = name;
        this.pwd = pwd;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name = "+userName+",pwd = "+pwd+",id = "+id;
    }
}
class Customer implements Externalizable{

    private static String name;
    private String pwd;
    private transient int id;

    public Customer(String name,String pwd,int id){
        this.name = name;
        this.pwd = pwd;
        this.id = id;
    }

    public String toString(){
        return "name = "+name+",pwd = "+pwd+",id = "+id;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        //out.writeChars(pwd);
        out.writeInt(id);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        //pwd = in.readLine();
        id = in.readInt();
    }
}