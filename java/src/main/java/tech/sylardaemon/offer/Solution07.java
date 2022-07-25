package tech.sylardaemon.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            memory.put(inorder[i], i);
        }
        TreeNode root = recursive(preorder, memory, 0, 0, inorder.length - 1);
        return root;
    }

    private TreeNode recursive(int[] preorder, Map<Integer, Integer> inorder_memory,
                               int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        TreeNode t = new TreeNode(preorder[pre_root]);

        int i = inorder_memory.get(preorder[pre_root]);

        t.left = recursive(preorder, inorder_memory,
                pre_root + 1, in_left, i - 1);
        t.right = recursive(preorder, inorder_memory,
                pre_root + i - in_left + 1, i + 1, in_right);

        return t;
    }
}
