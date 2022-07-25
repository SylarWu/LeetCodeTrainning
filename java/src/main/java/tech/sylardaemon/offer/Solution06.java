package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution06 {
    public int[] reversePrint(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null){
            stack.addLast(cur);
            cur = cur.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; ++i){
            result[i] = stack.removeLast().val;
        }
        return result;
    }

}
