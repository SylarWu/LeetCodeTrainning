package tech.sylardaemon.offer;

public class Solution53 {
    public int search(int[] nums, int target) {
        int index = bi_search(nums, target);
        if (index == -1){
            return 0;
        }
        int left = index - 1, right = index + 1;
        while (left >= 0 && nums[left] == target){
            --left;
        }
        while (right < nums.length && nums[right] == target){
            ++right;
        }
        return right - left - 1;
    }

    private int bi_search(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            if (nums[middle] > target){
                right = middle - 1;
            }else if (nums[middle] < target){
                left= middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public int missingNumber(int[] nums) {
        if (nums[nums.length - 1] == nums.length - 1){
            return nums.length;
        }
        return special_bi_search(nums);
    }

    private int special_bi_search(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right){
            int middle = left + (right - left) / 2;
            if (nums[middle] == middle){
                left = middle + 1;
            }else{
                right = middle;
            }
        }
        return left;
    }

}
