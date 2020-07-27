package day01;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.TRANSACTION_MODE;

public class dayunknow04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x; }
    }
    public TreeNode reBuildTree (int[]pre,int[]in) {
        if (pre.length ==0 || in.length==0) {
            return null;//空树
        }
        return reBuild(pre,0,pre.length-1,in,0,in.length-1);
    }
    public TreeNode reBuild (int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if (preStart > preEnd || inStart>inEnd) {
            return null;
        }
        TreeNode root =new TreeNode(pre[preStart]);
        int i = inStart;
        for (;i<=inEnd;i++) {
            if (in[i]==pre[preStart]) {//在中序遍历的结果中找根节点(前序遍历结果的第一个元素
                //根据中序,我们能确定左子树的节点个数是i - instart
                //所以从preStart+1连续上i-inStart个元素 就是左子树的前序序列
                root.left = reBuild(pre,preStart+1,i-inStart+preStart,in,inStart,i-1);
                root.right = reBuild(pre,preStart+1+i-inStart,preEnd,in,i+1,inEnd);
                break;
            }
        }
        return root;
    }

}
