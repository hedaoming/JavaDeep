package offer.chapter2;

/**
 * Created by ipc on 2017/6/8.
 */
public class RepalceStr {
    public static void main(String args[]){
            String s1 = new String("hi hi");
            String s2 = new String("hi  hi");
            StringBuffer str = new StringBuffer();
            str.append("hello wo");
            String s = replaceSpace(new StringBuffer("hello world"));//hello20%world
            String s3 = replaceSpace(new StringBuffer("hello  wor ld"));//hello20%20%wor20%ld
            System.out.println(s);
            System.out.println(s3);
    }

    public static String replaceSpace(StringBuffer str) {
        //遍历str，记录空格数，最终长度=当前长度+空格数*2
        int count = 0;
        String s = null;
        for (int i = 0;i<str.length();i++) {
            if(str.charAt(i)==' '){
                count++;
            }
        }

        if(count!=0){
            //指向当前str最末尾下标:在StringBuffer中，每增加一个空格，会自动加多两个不明符号,而在String中则不会这样
            //count*2+1是为了确保i总是指向原始String的末尾
            //乌龙事件：原来是代码层面问题，不明的字符是我自己添加的，在新申请空间后加入的，难怪一直看StringBuffer的源码也看不出是哪里
            //会自动添加了两个字符呢。

            int i = str.length()-1;
            //申请空间
            str.setLength(str.length()+count*2);
            //指向替换后的str最末尾下标
            int j = str.length()-1;

            while(true){
                if(i==j){
                    //得到结果退出
                    break;
                }
                if(str.charAt(i)!=' '){
                    //没遇到空格时，就逐个移动
                    str.setCharAt(j,str.charAt(i));
                    i--;
                    j--;
                }else{
                    //遇到空格时，就添加字符串
                    str.setCharAt(j,'0');
                    j--;
                    str.setCharAt(j,'2');
                    j--;
                    str.setCharAt(j,'%');
                    j--;
                    i--;
                }
            }
        }
        s = str.toString();
        return s;
    }
}
