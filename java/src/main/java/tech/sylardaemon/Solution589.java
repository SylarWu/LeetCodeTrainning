package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(Node t, List<Integer> list){
        if (t != null){
            list.add(t.val);
            for (Node c : t.children){
                dfs(c, list);
            }
        }
    }
}
