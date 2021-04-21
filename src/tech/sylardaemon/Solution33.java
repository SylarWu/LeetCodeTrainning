package tech.sylardaemon;

public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = n - 1;
        int pivot;
        while (left <= right){
            pivot = (left + right) / 2;
            if (nums[pivot] == target){
                return pivot;
            }
            if (nums[left] <= nums[pivot]){
                if (nums[left] <= target && target < nums[pivot]){
                    right = pivot - 1;
                }else{
                    left = pivot + 1;
                }
            }else{
                if (nums[pivot] < target && target <= nums[n - 1]){
                    left = pivot + 1;
                }else{
                    right = pivot - 1;
                }
            }
        }
        return -1;
    }
}
