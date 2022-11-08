package tech.sylardaemon.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return two_pointer_method(headA, headB);
    }

    private ListNode two_pointer_method(ListNode headA, ListNode headB){
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2){
            p1 = p1 == null ? headB: p1.next;
            p2 = p2 == null ? headA: p2.next;
        }
        return p1;
    }

    private ListNode map_method(ListNode headA, ListNode headB){
        final Object PRESENT = new Object();
        Map<ListNode, Object> memory = new HashMap<>();
        ListNode cur = headA;
        while (cur != null){
            memory.put(cur, PRESENT);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null){
            if (memory.containsKey(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
