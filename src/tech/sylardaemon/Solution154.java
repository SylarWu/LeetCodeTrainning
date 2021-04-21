package tech.sylardaemon;

public class Solution154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pivot;
        while (left < right){
            pivot = (left + right) / 2;
            if (nums[pivot] < nums[right]){
                right = pivot;
            }else if (nums[pivot] > nums[right]){
                left = pivot + 1;
            }else{
                --right;
            }
        }
        return nums[left];
    }
}
