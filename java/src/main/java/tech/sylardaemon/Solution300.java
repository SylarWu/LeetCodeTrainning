package tech.sylardaemon;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1;i < nums.length ; ++i){
            dp[i] = 1;
            for (int j = 0; j < i; ++j){
                if (nums[i] > nums[j]){
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
            }
            result = dp[i] > result ? dp[i] : result;
        }
        return result;
    }
}
