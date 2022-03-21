package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

public class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        return travel(root, root, k);
    }

    private boolean travel(TreeNode root, TreeNode t, int target){
        if (t == null){
            return false;
        }
        if (dfs(t, root, target)){
            return true;
        }
        boolean left = travel(root, t.left, target);
        boolean right = travel(root, t.right, target);
        return left || right;
    }

    private boolean dfs(TreeNode baseNode, TreeNode searchNode, int target){
        if (searchNode == null){
            return false;
        }
        if (baseNode == searchNode){
            return dfs(baseNode, searchNode.left, target) || dfs(baseNode, searchNode.right, target);
        }
        if (baseNode.val + searchNode.val > target){
            return dfs(baseNode, searchNode.left, target);
        }else if (baseNode.val + searchNode.val < target){
            return dfs(baseNode, searchNode.right, target);
        }
        return true;
    }

}
