package tech.sylardaemon;

import tech.sylardaemon.basic.ListNode;

public class Solution2 {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0,null);
        boolean step = false;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode t = res;
        while (t1 != null && t2 != null){
            t.val = t1.val + t2.val + (step ? 1 : 0);
            if (t.val >= 10){
                t.val = t.val % 10;
                step = true;
            }else{
                step = false;
            }
            t1 = t1.next;
            t2 = t2.next;
            if (t1 != null || t2!= null || step){
                t.next = new ListNode(0,null);
                t = t.next;
            }
        }
        while (t1 != null){
            t.val = t1.val + (step ? 1 : 0);
            if (t.val >= 10){
                t.val = t.val % 10;
                step = true;
            }else{
                step = false;
            }
            t1 = t1.next;
            if (t1 != null || step){
                t.next = new ListNode(0,null);
                t = t.next;
            }
        }
        while (t2 != null){
            t.val = t2.val + (step ? 1 : 0);
            if (t.val >= 10){
                t.val = t.val % 10;
                step = true;
            }else{
                step = false;
            }
            t2 = t2.next;
            if (t2 != null || step){
                t.next = new ListNode(0,null);
                t = t.next;
            }
        }
        if (step){
            t.val = 1;
        }
        return res;
    }
}
