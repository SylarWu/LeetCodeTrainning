package tech.sylardaemon.offer;

public class Solution55 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else if (root.left == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return is_balanced_recursive(root) >= 0;
    }

    private int is_balanced_recursive(TreeNode node){
        if (node == null){
            return 0;
        }
        int left = is_balanced_recursive(node.left);
        int right = is_balanced_recursive(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
