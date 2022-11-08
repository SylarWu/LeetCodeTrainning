package tech.sylardaemon.offer;

import java.util.LinkedList;
import java.util.List;

public class Solution34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        return recursive_method(root, target);
    }

    private List<List<Integer>> recursive_method(TreeNode root, int target){
        List<List<Integer>> result = new LinkedList<>();
        dfs(root, target, result, new LinkedList<Integer>());
        return result;
    }

    private void dfs(TreeNode node, int target, List<List<Integer>> result, LinkedList<Integer> temp){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null && node.val == target){
            List<Integer> ready = new LinkedList<>();
            ready.addAll(temp);
            ready.add(node.val);
            result.add(ready);
            return;
        }
        temp.addLast(node.val);
        dfs(node.left, target - node.val, result, temp);
        dfs(node.right, target - node.val, result, temp);
        temp.removeLast();
    }
}
