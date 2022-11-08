package tech.sylardaemon.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 2){
            return true;
        }
        int[] inorder = postorder.clone();
        Arrays.sort(inorder);
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i){
            memory.put(inorder[i], i);
        }
        return recursive_check(postorder, memory, postorder.length - 1, 0, inorder.length - 1);
    }
    private boolean recursive_check(int[] postorder, Map<Integer, Integer> memory, int root, int left, int right){
        if (left > right){
            return true;
        }
        int middle = memory.get(postorder[root]);
        if (middle >= left && middle <= right){
            return recursive_check(postorder, memory, root - 1 - (right - middle), left, middle - 1) &&
                    recursive_check(postorder, memory, root - 1, middle + 1, right);
        }
        return false;
    }
}
