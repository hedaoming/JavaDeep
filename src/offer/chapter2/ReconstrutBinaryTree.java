package offer.chapter2;

/**
 * Created by ipc on 2017/6/14.
 */
public class ReconstrutBinaryTree {
    /*
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //结束条件，边界条件

        //新建结点
        TreeNode treeNode = new TreeNode(pre[0]);
        //找到中序的根节点，以此分界成左右子树
        int  split = 0;
        for(int i =0;i<in.length;i++){
            if(in[i]==pre[0]){
                split = i;
                break;
            }
        }
        //左子树，右子树
        int[] leftTree = new int[split];
        int[] rightTree = new int[in.length-split-1];
        for(int i = 0;i<split;i++){
            leftTree[i] = in[i];
        }
        for(int i = split;i<in.length;i++){
            rightTree[i] = in[i];
        }
        //新前序-->左
        int[] newLeftPre = new int[pre.length-1];
        for(int i =0;i<pre.length;i++){
            newLeftPre[i] = pre[i+1];
        }
        //新前序--》右
        int[] newRightPre = new int[pre.length];
        //递归左子树，原本前序-开头结点 = 新前序，原本中序传入左右子树形成新中序
        treeNode.left = this.reConstructBinaryTree(newLeftPre,leftTree);
        //递归右子树
        treeNode.right = this.reConstructBinaryTree(null,rightTree);

        return treeNode;
    }
    */

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode = recon(pre,0,pre.length-1,in,0,in.length-1);
        return treeNode;
    }

    public TreeNode recon(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
        //边界条件
        if(pre==null||in==null){
            return null;
        }
        if(startPre>endPre||startIn>endIn){
            return null;
        }
        //新建结点
        TreeNode treeNode = new TreeNode(pre[startPre]);
        //找到中序里面根节点的索引
        int split = 0;
        for(int i = 0;i<in.length;i++){
            if(in[i]==pre[startPre]){
                split = i;
                break;
            }
        }
        //设置左右子树并递归
        treeNode.left = this.recon(pre,startPre+1,split-startIn+startPre,in,startIn,split-1);
        treeNode.right = this.recon(pre,split-startIn+startPre+1,endPre,in,split+1,endIn);

        return treeNode;

    }

    public static void main(String args[]){
        TreeNode root = new So().reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6});
        System.out.print(root.toString());

    }

}
class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

class So{
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        return root;
    }
}