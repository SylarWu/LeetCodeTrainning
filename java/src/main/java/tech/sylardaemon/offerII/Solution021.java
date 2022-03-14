package tech.sylardaemon.offerII;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Solution021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = head;
        int skip = 1;
        while (cur.next != null){
            if (skip >= n){
                pre = pre.next;
            }
            cur = cur.next;
            ++skip;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }
}
