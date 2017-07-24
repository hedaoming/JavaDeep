package offer.chapter4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ipc on 2017/7/24.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathSumTree {
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        t1.left = t2;
        t1.right = t3;
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t2.left = t4;
        t2.right = t5;
        FindPath(t1,22);
    }

    //全局list
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //路劲list
        ArrayList<Integer> pathList = new ArrayList<Integer>();
        int sum = root.val;
        if(root!=null){
            Path(root,target,pathList,sum);
        }else{
            return null;
        }
        return list;
    }

    private static void Path(TreeNode root, int target, ArrayList<Integer> pathList,int sum) {
        //递归结束
        if(root==null){
            return;
        }
        ArrayList<Integer> newPathList = new ArrayList<Integer>();
        //初始化pathList
        if(pathList != null){
            if(!pathList.isEmpty()){
                for(int i = 0;i<pathList.size();i++){
                    newPathList.add(pathList.get(i));
                }
            }
        }
        //是否得到结果
        if(sum<target){
            newPathList.add(root.val);
            if(root.left!=null){
                int sumLeft = sum +root.left.val;
                Path(root.left,target,newPathList,sumLeft);
            }
            if(root.right!=null){
                int sumRight = sum+root.right.val;
                Path(root.right,target,newPathList,sumRight);
            }
        }else if(sum==target){
            newPathList.add(root.val);
            list.add(newPathList);
            //后续不再递归
            return;
        }else{
            return;
        }

    }
}
