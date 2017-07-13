package offer.chapter4;

import java.util.ArrayList;

/**
 * Created by ipc on 2017/7/13.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 * 思路：
 *      后序遍历的规律：后序数组中，最后一个元素为根节点，前面能比根节点小的是左子树，大的是右子树
 *                  从而能用递归来将其全部划分出来，要是遇到情况不符合的则不是后序 了
 */
public class TreeNodeBST {
    public static void main(String args[]){
        System.out.println(new TreeNodeBST().VerifySquenceOfBST(new int[]{4,6,7,5}));
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        //输入处理
        if(sequence==null || sequence.length<1){
            return false;
        }
        //输入：只有一个输入，只有两个输入

        return B(sequence);
    }
    public void BST(int[] sequence){
        //递归结束条件
        if(sequence.length<2){
            return;
        }
        //最后一个元素为根节点
        int root = sequence[sequence.length-1];
        //左子树，右子树
        ArrayList<Integer> leftList = new ArrayList<Integer>();
        ArrayList<Integer> rightList = new ArrayList<Integer>();
        for(int i = 0;i<sequence.length;i++){
            if(sequence[i]<root){
                leftList.add(sequence[i]);
            }else{
                rightList.add(sequence[i]);
            }
        }
        int[] left = new int[leftList.size()];
        int[] right = new int[rightList.size()];
        for(int i = 0;i<left.length;i++){
            left[i] = leftList.get(i);
        }
        for(int i = 0;i<right.length;i++){
            right[i] = rightList.get(i);
        }

        BST(left);
        BST(right);
    }
    public boolean B(int[] sequence){
        //递归结束
        if(sequence.length<2){
            return true;
        }
        //记录第一个比根节点大的数下标
        int index = 0;
        int root = sequence[sequence.length-1];
        //index之前的都比根节点小
        for(int i = 0;i<sequence.length;i++){
            if(sequence[i]>root){
                index = i;
                break;
            }
            if(i==sequence.length-1 && index == 0){
                index = sequence.length-1;
            }
        }
        int[] left = new int[index];
        int[] right = new int[sequence.length-index-1];
        for(int i = 0;i<sequence.length-1;i++){
            if(i<index){
                left[i] = sequence[i];
            }else{
                right[i-index] = sequence[i];
            }
        }
        //左子树是否存在比根节点大的:不用判断了，index已经保证了
        //右子树是否存在比根节点小 的
        for(int i =0;i<right.length;i++){
            if(right[i]<root){
                return false;
            }
        }
        //递归左右子树
        return B(left) && B(right);
    }
}
