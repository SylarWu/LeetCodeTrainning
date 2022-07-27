package tech.sylardaemon.offer;

public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
