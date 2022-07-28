package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null){
            return true;
        }else if (A == null || B == null){
            return false;
        }
        if (recursive(A, B)){
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSubStructure_iter(TreeNode A, TreeNode B){
        if (A == null && B == null){
            return true;
        }else if (A == null || B == null){
            return false;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = A;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.removeLast();
            if (cur.val == B.val && recursive(cur, B)){
                return true;
            }
            cur = cur.right;
        }
        return false;
    }

    private boolean recursive(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }else if (A == null || A.val != B.val){
            return false;
        }
        return recursive(A.left, B.left) && recursive(A.right, B.right);
    }
}
