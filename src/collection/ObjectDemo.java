package collection;

import java.util.ArrayList;

/**
 * Created by ipc on 2017/7/11.
 */
public class ObjectDemo {

    public static void main(String args[]){
        ArrayList list = new ArrayList();
        User user = new User();
        for(int i = 0;i<10;i++){
            user.setName("user"+i);
            list.add(user);
        }
        System.out.println(list);
    }
}

class User{
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return "UserName:"+name;
    }

}
