package tech.sylardaemon.offer;

public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode ahead = head;
        ListNode behind = head;
        while (ahead.next != null){
            if (k <= 1){
                behind = behind.next;
            }
            ahead = ahead.next;
            --k;
        }
        return behind;
    }
}
