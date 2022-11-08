package tech.sylardaemon.offer;

public class Solution40 {
    class MiniRootHeap{
        int[] core;
        int index;
        MiniRootHeap(int size){
            this.core = new int[size];
            this.index = -1;
        }

        void swap(int i, int j){
            int temp = core[i];
            core[i] = core[j];
            core[j] = temp;
        }

        public void push(int value) {
            ++index;
            core[index] = value;
            int cur = index;
            while (cur > 0){
                int parent = (cur - 1) / 2;
                if (core[parent] > core[cur]){
                    swap(parent, cur);
                }else{
                    break;
                }
                cur = parent;
            }
        }

        public int pop() {
            int result = core[0];
            core[0] = core[index--];
            int cur = 0;
            while (cur <= index){
                int left = cur * 2 + 1, right = cur * 2 + 2;
                if (left > index){
                    break;
                }else if (right > index){
                    if (core[cur] > core[left]){
                        swap(cur, left);
                    }
                    break;
                }else {
                    int smallest = core[left] <= core[right] ? left: right;
                    if (core[cur] > core[smallest]) {
                        swap(cur, smallest);
                    }else{
                        break;
                    }
                    cur = smallest;
                }
            }
            return result;
        }
    }
    private int[] mini_root_heap_method(int[] arr, int k){
        int[] result = new int[k];
        MiniRootHeap mini_root_heap = new MiniRootHeap(arr.length);
        for (int i = 0; i < arr.length; ++i){
            mini_root_heap.push(arr[i]);
        }
        for (int i = 0; i < k; ++i){
            result[i] = mini_root_heap.pop();
        }
        return result;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        return mini_root_heap_method(arr, k);
    }

    private int[] quick_sort_method(int[] arr, int k){
        int[] result = new int[k];
        quick_sort(arr, 0, arr.length - 1);
        for (int i = 0; i < k; ++i){
            result[i] = arr[i];
        }
        return result;
    }

    private void quick_sort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int pivot = arr[left];
        int i = left, j = right;
        while (i < j){
            while (i < j && arr[j] >= pivot){
                --j;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot){
                ++i;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        quick_sort(arr, left, i - 1);
        quick_sort(arr, i + 1, right);
    }
}
