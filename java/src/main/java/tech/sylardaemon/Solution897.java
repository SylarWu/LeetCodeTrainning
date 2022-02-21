package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;

public class Solution897 {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode res = new TreeNode(-1,null,null);
        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode cur = root;
        TreeNode resCur = res;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        while (!stack.isEmpty()){
            cur = stack.pop();
            cur.left = null;
            resCur.right = cur;
            resCur = resCur.right;
            cur = cur.right;
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res.right;
    }
}
