package offer.chapter2;

/**
 * Created by ipc on 2017/6/7.
 */
public class ArraySolution {
    public static void main(String args[]){
        boolean flag ;
        flag = Find(16,new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}});
        //flag = Find(16,int [][] {[[]]});
        System.out.println(flag);
        //int[][] ints = new int[][]
    }
    public static boolean Find(int target, int [][] array) {

        int column = array.length - 1;
        int row = 0;
        //空数组直接返回false
        if(array != null){
            while (true) {
                //验证行列是否已经越界了:二维数组四种越界
                if(column>array[0].length-1 || column<0 || row>array.length-1 || row<0){
                    return false;
                }
                //找到了
                if (array[row][column] == target) {
                    System.out.print(row + "," + column);
                    return true;
                } else if (array[row][column] > target) {
                    //从右上角找起，目标数小于右上角数则去除整一列
                    column--;
                } else {
                    //去除整一行
                    row++;
                }
            }
        }else{
            return false;
        }

    }
}
