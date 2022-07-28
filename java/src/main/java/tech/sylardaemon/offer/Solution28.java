package tech.sylardaemon.offer;

public class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode A, TreeNode B){
        if (A == null && B == null){
            return true;
        }else if (A == null || B == null){
            return false;
        }
        return A.val == B.val && isSymmetric(A.left, B.right) && isSymmetric(A.right, B.left);
    }
}
