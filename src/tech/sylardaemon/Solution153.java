package tech.sylardaemon;

public class Solution153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pivot;
        while (left < right){
            pivot = (left + right) / 2;
            if (nums[pivot] < nums[right]){
                right = pivot;
            }else{
                left = pivot + 1;
            }
        }
        return nums[left];
    }
}
