package tech.sylardaemon;

import tech.sylardaemon.basic.ListNode;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode before = dummy;
        ListNode pre = before.next;
        if (pre == null){
            return null;
        }
        ListNode cur = pre.next;
        if (cur == null){
            return dummy.next;
        }
        ListNode after = cur.next;
        while (true){
            before.next = cur;
            cur.next = pre;
            pre.next = after;
            if (after == null || after.next == null){
                break;
            }
            before = pre;
            pre = after;
            cur = pre.next;
            after = cur.next;
        }
        return dummy.next;
    }
}
