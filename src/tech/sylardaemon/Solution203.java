package tech.sylardaemon;

import tech.sylardaemon.basic.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode newHead = new ListNode(-1,head);
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                cur = cur.next;
                pre.next = cur;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
