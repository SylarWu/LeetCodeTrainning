package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        Node head = null;
        Node cur = root, pre = null;
        LinkedList<Node> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (head == null){
                head = cur;
            }else{
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}
