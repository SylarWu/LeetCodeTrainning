package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root,long left, long right){
        if (root == null){
            return true;
        }
        if (root.val <= left || root.val >= right){
            return false;
        }
        return isValidBST(root.left,left,root.val) && isValidBST(root.right,root.val,right);
    }

    private boolean basicStackMethod(TreeNode root) {
        if (root == null){
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode t = root;
        int max = Integer.MIN_VALUE;
        boolean first = true;
        while (t != null){
            stack.push(t);
            t = t.left;
        }
        while (!stack.isEmpty()){
            t = stack.pop();
            if (!first && max >= t.val){
                return false;
            }
            max = t.val;
            if (first){
                first = false;
            }
            t = t.right;
            while (t != null){
                stack.push(t);
                t = t.left;
            }
        }
        return true;
    }
}
