package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Interview59 {
    class MaxQueue {

        LinkedList<Integer> queue;
        LinkedList<Integer> max_queue;


        public MaxQueue() {
            queue = new LinkedList<>();
            max_queue = new LinkedList<>();
        }

        public int max_value() {
            if (max_queue.isEmpty()){
                return -1;
            }
            return max_queue.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!max_queue.isEmpty() && max_queue.peekLast() < value){
                max_queue.pollLast();
            }
            max_queue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()){
                return -1;
            }
            if (queue.peek().equals(max_queue.peek())){
                max_queue.poll();
            }
            return queue.poll();
        }
    }
}
