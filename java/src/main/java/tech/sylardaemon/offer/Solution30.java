package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution30 {
    class MinStack {

        LinkedList<Integer> stack;
        LinkedList<Integer> mini_stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new LinkedList<>();
            mini_stack = new LinkedList<>();
        }

        public void push(int x) {
            if (mini_stack.isEmpty() || x <= mini_stack.getLast()){
                mini_stack.addLast(x);
            }
            stack.addLast(x);
        }

        public void pop() {
            if (stack.removeLast().equals(mini_stack.getLast())){
                mini_stack.removeLast();
            }
        }

        public int top() {
            if (!stack.isEmpty()){
                return stack.getLast();
            }
            return 0;
        }

        public int min() {
            if (!mini_stack.isEmpty()){
                return mini_stack.getLast();
            }
            return 0;
        }
    }
}
