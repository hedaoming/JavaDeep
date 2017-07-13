package offer.chapter4;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by ipc on 2017/7/12.
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * 思路：
 *      类似前序遍历，不过每次遍历时，把左右节点加入集合中，接着才递归
 *      考虑：null，以及递归结束条件
 * 正确思路：
 *      借助一个容器，存储左右节点，根据需求，容器是队列
 *         8
 *    6         10
 * 5    7    9   11
 *      8打印，6 和10加入容器
 *      6打印，10，5，7              （ 容器中取出首位6打印，其子节点5，7加入容器）
 *      1打印，5，7，9，11
 */
public class PrintTreeNodeTop {
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>(1000);

    @Test
    public static void main(String args[]){
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        PrintFromTopToBottom(node1);
    }
    //正确思路
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null){
            return null;
        }
        addTreeNode(root);

        return list;
    }
    //方法一
    public static void addTreeNode(TreeNode root){
        list.add(root.val);
        //顺序加入队列
        if(root.left!=null || root.right!=null){
            queue.add(root.left);
            queue.add(root.right);
        }
        //递归结束条件
        if(queue.isEmpty()){
            return;
        }
        addTreeNode(queue.poll());
    }
    //方法二
    public ArrayList<Integer> addTree(TreeNode root){
        //加入根节点
        //子节点加入队列
        //循环队列

        queue.add(root);
        while(!queue.isEmpty()){
            if(root.left!=null){
                queue.add(root.left);
            }
            if(root.right!=null){
                queue.add(root.right);
            }
            list.add(queue.poll().val);
        }
        return list;
    }
    /*
    思路：
    int count = 0;
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null){
            return null;
        }
        addTreeNode(root);
        return list;
    }
    public void addTreeNode(TreeNode root){
        //第一次添加根节点
        if(count==0){
            list.add(root.val);
        }
        count++;
        //递归结束条件
        if(root.left==null || root.right==null){
            return;
        }
        list.add(root.left.val);
        list.add(root.right.val);
        //递归
        addTreeNode(root.left);
        addTreeNode(root.right);
    }
    */
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}