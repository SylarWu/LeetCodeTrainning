package tech.sylardaemon.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null){
            return null ;
        }
        Map<Node, Node> helper = new HashMap<>();
        Node cur = head;
        while (cur != null){
            helper.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        for (Node key : helper.keySet()){
            Node next = key.next;
            Node random = key.random;
            helper.get(key).next = helper.get(next);
            helper.get(key).random = helper.get(random);
        }
        return helper.get(head);
    }

    private Node O1_space_method(Node head){
        if (head == null){
            return null;
        }
        /* first round: initiate */
        Node cur = head;
        while (cur != null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        /* second round: random point*/
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        /* third round: split */
        Node new_head = head.next;
        cur = head;
        while (cur.next != null){
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return new_head;
    }
}
