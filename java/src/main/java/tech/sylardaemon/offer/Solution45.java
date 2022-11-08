package tech.sylardaemon.offer;

import java.util.Comparator;

public class Solution45 {
    public String minNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        quick_sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = String.valueOf(o1) + String.valueOf(o2);
                String str2 = String.valueOf(o2) + String.valueOf(o1);
                for (int i = 0; i < str1.length(); ++i){
                    int value = str1.charAt(i) - str2.charAt(i);
                    if (value != 0){
                        return value;
                    }
                }
                return 0;
            }
        }, 0, nums.length - 1);
        for (int i = 0; i < nums.length; ++i){
            result.append(nums[i]);
        }
        return result.toString();
    }

    private void quick_sort(int[] nums, Comparator<Integer> comparator, int left, int right){
        if (left >= right){
            return;
        }
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j){
            while (i < j && comparator.compare(nums[j], pivot) >= 0){
                --j;
            }
            nums[i] = nums[j];
            while (i < j && comparator.compare(nums[i], pivot) <= 0){
                ++i;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quick_sort(nums, comparator, left, i - 1);
        quick_sort(nums, comparator, i + 1, right);
    }
}
