package tech.sylardaemon.offer;

public class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }
        if (l2 != null){
            cur.next = l2;
        }
        return dummyHead.next;
    }
}
