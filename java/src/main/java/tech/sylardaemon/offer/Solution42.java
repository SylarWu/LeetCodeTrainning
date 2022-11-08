package tech.sylardaemon.offer;

public class Solution42 {
    public int maxSubArray(int[] nums) {
        int max_result = nums[0], presum = 0;
        for (int i = 0;i < nums.length; ++i){
            presum = Math.max(presum + nums[i], nums[i]);
            max_result = Math.max(max_result, presum);
        }
        return max_result;
    }
}
