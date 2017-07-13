package offer.chapter4;

/*import offer.chapter3.TreeNode;*/

/**
 * Created by ipc on 2017/7/2.
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 思路：
 *      根节点：左右子节点，交换
 *          递归左右子节点：左子节点当做根节点，继续递归；右子节点当作根节点，递归；
 */
public class MirrorTreeNode {
    /*public void Mirror(TreeNode root) {
        if(root.left==null && root.right==null){
            return;
        }

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        //if(root.left!=null)
            Mirror(root.left);//遍历左子树
        //if(root.right!=null)
            Mirror(root.right);//遍历右子树


    }*/
}

