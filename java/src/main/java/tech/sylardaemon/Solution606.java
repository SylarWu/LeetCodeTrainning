package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

public class Solution606 {
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        preOrder(root, result);
        return result.toString();
    }

    private void preOrder(TreeNode t, StringBuilder result){
        if (t == null){
            result.append("()");
            return;
        }
        result.append(t.val);
        if (t.left != null && t.right != null){
            result.append("(");
            preOrder(t.left, result);
            result.append(")");
            result.append("(");
            preOrder(t.right, result);
            result.append(")");
        }else if (t.left != null){
            result.append("(");
            preOrder(t.left, result);
            result.append(")");
        }else if (t.right != null){
            preOrder(t.left, result);
            result.append("(");
            preOrder(t.right, result);
            result.append(")");
        }
    }
}
