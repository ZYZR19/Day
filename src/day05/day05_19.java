package day05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class day05_19 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        q.offer(root);//把root入队列
        while(!q.isEmpty()) {
            TreeNode father = q.poll();//出队列拿出root
            ret.add(father.val);//把root加入到数组中
            if (father.left!=null) {//访问节点的左子树和右子树进行入队列 就变成父节点
                q.offer(father.left);
            }
            if (father.right!=null) {
                q.offer(father.right);
            }
        }
        return ret;
    }
}
