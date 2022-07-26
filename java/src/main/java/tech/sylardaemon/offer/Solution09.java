package tech.sylardaemon.offer;

import java.util.LinkedList;
import java.util.List;

public class Solution09 {
    class CQueue {
        LinkedList<Integer> stack_in;
        LinkedList<Integer> stack_out;

        public CQueue() {
            stack_in = new LinkedList<>();
            stack_out = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack_in.addLast(value);
        }

        public int deleteHead() {
            if (stack_out.isEmpty()){
                if (stack_in.isEmpty()){
                    return -1;
                }
                while (!stack_in.isEmpty()){
                    stack_out.addLast(stack_in.removeLast());
                }
            }
            return stack_out.removeLast();
        }
    }
}
