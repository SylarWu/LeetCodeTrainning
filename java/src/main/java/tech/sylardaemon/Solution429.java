package tech.sylardaemon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null){
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            List<Integer> layer = new LinkedList<>();
            for (int i = queue.size(); i > 0; --i){
                Node node = queue.poll();
                layer.add(node.val);
                for (Node child: node.children){
                    queue.offer(child);
                }
            }
            result.add(layer);
        }
        return result;
    }
}
