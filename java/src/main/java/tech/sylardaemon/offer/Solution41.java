package tech.sylardaemon.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution41 {

    class RootHeap {
        int[] data;
        int index;
        int capacity;
        Comparator<Integer> comparator;

        RootHeap(int capacity, Comparator<Integer> comparator) {
            this.capacity = capacity;
            data = new int[this.capacity];
            index = -1;
            this.comparator = comparator;
        }

        private void grow() {
            capacity *= 2;
            int[] temp = new int[capacity];
            for (int i = 0; i <= index; ++i) {
                temp[i] = data[i];
            }
            data = temp;
        }

        private void swap(int i, int j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        public void offer(int x) {
            if (index + 1 == capacity) {
                grow();
            }
            data[++index] = x;
            int cur = index;
            while (cur > 0) {
                int parent = (cur - 1) / 2;
                if (comparator.compare(data[cur], data[parent]) < 0) {
                    swap(cur, parent);
                } else {
                    break;
                }
                cur = parent;
            }
        }

        public int poll() {
            int result = data[0];
            data[0] = data[index--];
            int cur = 0;
            while (cur <= index) {
                int left = cur * 2 + 1, right = cur * 2 + 2;
                if (left > index) {
                    break;
                } else if (right > index) {
                    if (comparator.compare(data[cur], data[left]) > 0) {
                        swap(cur, left);
                    }
                    break;
                } else {
                    int next_swap = comparator.compare(data[left], data[right]) <= 0 ? left : right;
                    if (comparator.compare(data[cur], data[next_swap]) > 0) {
                        swap(cur, next_swap);
                    } else {
                        break;
                    }
                    cur = next_swap;
                }
            }
            return result;
        }

        public int peek() {
            return data[0];
        }

        public int size() {
            return index + 1;
        }


    }


    class MedianFinder {

        RootHeap mini_root_heap;
        RootHeap max_root_heap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            mini_root_heap = new RootHeap(10, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            max_root_heap = new RootHeap(10, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

        }

        public void addNum(int num) {
            if (mini_root_heap.size() == max_root_heap.size()) {
                mini_root_heap.offer(num);
                max_root_heap.offer(mini_root_heap.poll());
            } else {
                max_root_heap.offer(num);
                mini_root_heap.offer(max_root_heap.poll());
            }
        }

        public double findMedian() {
            if (mini_root_heap.size() == max_root_heap.size()) {
                return (mini_root_heap.peek() + max_root_heap.peek()) / 2.0;
            } else {
                return max_root_heap.peek();
            }
        }
    }
}
