package offer.chapter4;

import java.util.ArrayList;

/**
 * Created by ipc on 2017/7/3.
 */
public class MatrixIterator {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList result = new ArrayList();
        if(matrix == null){
            return result;
        }
        int columns = matrix.length;
        int rows = matrix[0].length;
        if(columns == 0){
            return result;
        }

        //添加上面一行
        //添加右边一列
        //添加下边一行
        //添加左边一列
        return null;
    }
}
