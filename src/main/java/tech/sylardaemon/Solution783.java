package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;

public class Solution783 {
    private int mini;
    private TreeNode pre;
    public int minDiffInBST(TreeNode root) {
        this.mini = Integer.MAX_VALUE;
        this.pre = null;
        inorderTravel(root);
        return this.mini;
    }

    private int stackBaseMethod(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode t = root;
        int mini = Integer.MAX_VALUE;
        while (t != null){
            stack.push(t);
            t = t.left;
        }
        while (!stack.isEmpty()){
            t = stack.pop();
            if (pre != null){
                mini = (t.val - pre.val) < mini ? (t.val - pre.val) : mini;
            }
            pre = t;
            t = t.right;
            while (t != null){
                stack.push(t);
                t = t.left;
            }
        }
        return mini;
    }

    private void inorderTravel(TreeNode t){
        if (t != null){
            inorderTravel(t.left);
            if (pre != null){
                this.mini = (t.val - this.pre.val) < this.mini ? (t.val - this.pre.val) : this.mini;
            }
            this.pre = t;
            inorderTravel(t.right);
        }
    }
}
