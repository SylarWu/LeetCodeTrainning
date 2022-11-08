package tech.sylardaemon.offer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        return max_root_heap_method(nums, k);
    }

    private int[] max_root_heap_method(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < k; ++i){
            queue.offer(new int[]{nums[i], i});
        }
        result[0] = queue.peek()[0];
        for (int i = k; i < nums.length; ++i){
            while (!queue.isEmpty() && queue.peek()[1] <= i - k){
                queue.poll();
            }
            queue.offer(new int[]{nums[i], i});
            result[i - k + 1] = queue.peek()[0];
        }
        return result;
    }

    private int[] max_queue_method(int[] nums, int k){
        int[] result = new int[nums.length - (k - 1)];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; ++i){
            while (!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
        }
        result[0] = queue.peek();
        for (int i = k; i < nums.length; ++i){
            if (queue.peek() == nums[i - k]){
                queue.poll();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
            result[i - k + 1] = queue.peek();
        }
        return result;
    }
}
