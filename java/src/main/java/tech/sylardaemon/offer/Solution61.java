package tech.sylardaemon.offer;

import java.util.Arrays;

public class Solution61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < nums.length - 1; ++i){
            if (nums[i] == 0){
                ++joker;
            }else if (nums[i] == nums[i + 1]){
                return false;
            }
        }
        return nums[nums.length - 1] - nums[joker] < 5;
    }
}
