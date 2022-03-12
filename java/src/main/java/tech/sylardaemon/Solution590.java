package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node t, List<Integer> list){
        if (t == null){
            return;
        }
        for (Node node : t.children){
            dfs(node, list);
        }
        list.add(t.val);
    }
}
