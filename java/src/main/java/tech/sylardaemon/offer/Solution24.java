package tech.sylardaemon.offer;

public class Solution24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = recursive(head);
        head.next = null;
        return newHead;
    }

    private ListNode simpleWay(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = cur.next;

        head.next = null;

        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;

        return cur;
    }

    private ListNode recursive(ListNode node){
        if (node.next == null){
            return node;
        }
        ListNode head = recursive(node.next);
        node.next.next = node;
        return head;
    }
}
