package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;

public class Solution99 {
    public void recoverTree(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode t = root;
        TreeNode pre = null;
        TreeNode leftSwitch = null;
        TreeNode rightSwitch = null;
        while (t != null || !stack.isEmpty()){
            while (t != null){
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            if (pre != null && pre.val > t.val){
                if (leftSwitch == null){
                    leftSwitch = pre;
                }
                rightSwitch = t;
            }
            pre = t;
            t = t.right;
        }
        int temp = leftSwitch.val;
        leftSwitch.val = rightSwitch.val;
        rightSwitch.val = temp;
    }
}
