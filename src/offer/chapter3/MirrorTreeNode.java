package offer.chapter3;

/**
 * Created by ipc on 2017/7/2.
 */
public class MirrorTreeNode {
    public void Mirror(TreeNode root) {
        TreeNode t = root;
        if(t==null){
            return;
        }
        t.left = root.right;
        t.right = root.left;
        Mirror(t.left);
    }
}
