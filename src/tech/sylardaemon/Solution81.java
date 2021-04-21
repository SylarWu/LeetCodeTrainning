package tech.sylardaemon;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1){
            return nums[0] == target;
        }
        int left = 0;
        int right = nums.length - 1;
        int pivot;
        while (left <= right){
            pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return true;
            }
            if (nums[left] == nums[pivot] && nums[pivot] == nums[right]) {
                ++left;
                --right;
            } else if (nums[left] <= nums[pivot]){
                if (nums[left] <= target && target < nums[pivot]){
                    right = pivot - 1;
                }else{
                    left = pivot + 1;
                }
            } else{
                if (nums[pivot] < target && target <= nums[n - 1]){
                    left = pivot + 1;
                }else{
                    right = pivot - 1;
                }
            }
        }
        return false;
    }

    private boolean firstInMyHead(int[] nums, int target){
        int n = nums.length;
        if (n == 1){
            return nums[0] == target;
        }
        boolean res = nums[0] == target;
        int i = 1;
        while (i < n && nums[i] >= nums[i - 1]){
            res = nums[i] == target || res;
            ++i;
        }
        if (res){
            return true;
        }
        return middleSearch(nums,target,i,n-1);
    }

    private boolean middleSearch(int[] nums,int target,int begin,int end){
        int middle;
        while (begin < end){
            middle = (begin + end) / 2;
            if (nums[middle] == target){
                return true;
            }else if (nums[middle] > target){
                end = middle - 1;
            }else {
                begin = middle + 1;
            }
        }
        return false;
    }
}
