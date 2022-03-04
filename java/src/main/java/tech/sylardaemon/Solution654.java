package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

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
}
