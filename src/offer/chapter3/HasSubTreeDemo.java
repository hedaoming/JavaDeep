package offer.chapter3;

/**
 * Created by ipc on 2017/7/1.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 思路：
 *      B若是A的子结构，那么A之中必定有一个节点与B的根节点相同
 *      递归一：遍历A，查看是否有节点和B的根节点相同
 *          若是有：递归二，查看A的左右子节点是否和B的左右子节点相同
 *          若是没有：递归一继续（下一个A节点）
 */
public class HasSubTreeDemo {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if(root1!=null && root2!=null){
            //递归判断是否根节点值相同
            if(root1.val==root2.val){
                //判断根节点相同的子节点是否相同：递归判断根节点
                result =  DoesEques(root1,root2);
            }
            //递归左子树
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            //递归右子树
            if(!result){
                result = HasSubtree(root2.right,root2);
            }

        }

        return result;

    }
    public boolean DoesEques(TreeNode root1,TreeNode root2){
        //递归结束条件
        //递归完root1，则root2比root1还长，则false
        if(root1==null){
            return false;
        }
        //递归完root2，则true
        if(root2==null){
            return true;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return DoesEques(root1.left,root2.left) && DoesEques(root1.right,root2.right);
    }


}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
