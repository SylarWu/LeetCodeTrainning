package tech.sylardaemon.offer;

public class Solution21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        int temp;
        while (left < right){
            while (left < right && nums[left] % 2 == 1){
                ++left;
            }
            while (left < right && nums[right] % 2 == 0){
                --right;
            }
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
