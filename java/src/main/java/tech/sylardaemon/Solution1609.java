package tech.sylardaemon;

import tech.sylardaemon.basic.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        int layer = 0;
        while (!queue.isEmpty()){
            boolean isFirst = true;
            int lastVal = 0;
            for (int i = queue.size(); i > 0; --i){
                TreeNode node = queue.poll();
                if (isFirst){
                    isFirst = false;
                    lastVal = node.val;
                    if ((layer % 2 == 0 && lastVal % 2 == 0) || (layer % 2 == 1 && lastVal % 2 == 1)){
                        return false;
                    }
                }else{
                    if ((layer % 2 == 0 && (node.val % 2 == 0 || lastVal >= node.val)) ||
                            (layer % 2 == 1 && (node.val % 2 == 1 || lastVal <= node.val))){
                        return false;
                    }
                    lastVal = node.val;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            ++layer;
        }
        return true;
    }
}
