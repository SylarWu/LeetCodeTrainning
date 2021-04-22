package tech.sylardaemon;


import tech.sylardaemon.basic.ListNode;

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode newHead = new ListNode(-1,head);
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur.next != null){
            System.out.println(pre.val);
            if (k >= n){
                pre = pre.next;
            }
            cur = cur.next;
            ++k;
        }
        pre.next = pre.next.next;
        return newHead.next;
    }
}
