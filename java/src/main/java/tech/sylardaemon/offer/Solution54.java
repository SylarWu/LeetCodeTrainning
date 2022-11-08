package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution54 {
    public int kthLargest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            --k;
            if (k == 0){
                return cur.val;
            }
            cur = cur.left;
        }
        return -1;
    }
}
