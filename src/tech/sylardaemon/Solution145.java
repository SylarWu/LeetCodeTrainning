package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTravel(root);
    }

    private List<Integer> postorderTravel(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        TreeNode t = root;
        TreeNode pre = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (t != null || !stack.isEmpty()){
            while (t != null){
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            if (t.right == null || t.right == pre){
                res.add(t.val);
                pre = t;
                t = null;
            }else{
                stack.push(t);
                t = t.right;
            }
        }
        return res;
    }

    private void postorderTravelSimple(TreeNode t,List<Integer> res){
        if (t != null){
            postorderTravelSimple(t.left,res);
            postorderTravelSimple(t.right,res);
            res.add(t.val);
        }
    }
}
