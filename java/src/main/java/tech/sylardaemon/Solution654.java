package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructRecursive(nums, 0, nums.length - 1);
    }
    private TreeNode constructRecursive(int[] nums, int left, int right){
        if (left > right){
            return null;
        }
        int maxIndex = left;
        for (int i = left; i <= right; ++i){
            maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructRecursive(nums, left, maxIndex - 1);
        root.right = constructRecursive(nums, maxIndex + 1, right);
        return root;
    }

    private TreeNode decreaseStackMethod(int[] nums){
        LinkedList<TreeNode> decreaseStack = new LinkedList<>();
        TreeNode cur = null;
        for (int i = 0; i < nums.length; ++i){
            cur = new TreeNode(nums[i]);

            while (!decreaseStack.isEmpty() && decreaseStack.peek().val < cur.val){
                TreeNode temp = decreaseStack.pop();

                if (!decreaseStack.isEmpty() && decreaseStack.peek().val < cur.val){
                    decreaseStack.peek().right = temp;
                }else{
                    cur.left =temp;
                }
            }
            decreaseStack.push(cur);
        }

        while (!decreaseStack.isEmpty()){
            cur  = decreaseStack.pop();
            if (!decreaseStack.isEmpty()){
                decreaseStack.peek().right = cur;
            }
        }
        return cur;
    }
}
