package tech.sylardaemon.offer;

public class Solution51 {
    public int reversePairs(int[] nums) {
        return merge_method(nums);
    }

    private int simple_method(int[] nums){
        int count = 0;
        for (int i = 0; i < nums.length; ++i){
            for (int j = i + 1; j < nums.length; ++j){
                count += nums[i] > nums[j] ? 1: 0;
            }
        }
        return count;
    }

    private int merge_method(int[] nums){
        if (nums == null || nums.length <= 1){
            return 0;
        }
        int count = mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        return count;
    }

    private int mergeSort(int[] main, int[] backup, int left, int right){
        if (left >= right){
            return 0;
        }
        int middle = left + (right - left) / 2;
        int left_count = mergeSort(main, backup, left, middle);
        int right_count = mergeSort(main, backup, middle + 1, right);
        if (main[middle] <= main[middle + 1]){
            return left_count + right_count;
        }
        return left_count + right_count + merge(main, backup, left, middle, right);
    }

    private int merge(int[] main, int[] backup, int left, int middle, int right){
        int count = 0;
        for (int i = left; i <= right; ++i){
            backup[i] = main[i];
        }
        int i = left, j = middle + 1, k = left;
        while (i <= middle && j <= right){
            if (backup[i] <= backup[j]){
                main[k++] = backup[i++];
            }else{
                main[k++] = backup[j++];
                count += (middle - i + 1);
            }
        }
        while (i <= middle){
            main[k++] = backup[i++];
        }
        while (j <= right){
            main[k++] = backup[j++];
        }
        return count;
    }

}
