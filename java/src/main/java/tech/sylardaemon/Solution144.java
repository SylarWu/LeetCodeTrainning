package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTravel(root);
    }

    private void preorderTravelSimple(TreeNode t,List<Integer> res){
        if (t != null){
            res.add(t.val);
            preorderTravelSimple(t.left,res);
            preorderTravelSimple(t.right,res);
        }
    }
    private List<Integer> preorderTravel(TreeNode root){
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode t = root;
        if (root == null){
            return res;
        }
        stack.push(t);
        res.add(t.val);
        t = t.left;
        while (t != null || !stack.isEmpty()){
            while (t != null){
                stack.push(t);
                res.add(t.val);
                t = t.left;
            }
            t = stack.pop();
            t = t.right;
        }
        return res;
    }
}
