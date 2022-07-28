package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        iter(root);
        return root;
    }

    private void iter(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;

                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.removeLast();
            cur = cur.right;
        }
    }

    private void recursive(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        recursive(root.left);
        recursive(root.right);
    }
}
