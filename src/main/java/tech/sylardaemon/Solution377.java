package tech.sylardaemon;

import java.util.Arrays;

public class Solution377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i){
            for (int num : nums){
                if (num <= i){
                    dp[i] += dp[i - num];
                }
            }
        }
        for (int i = 0; i <= target; ++i){
            System.out.print(dp[i]);
            System.out.print(",");
        }
        return dp[target];
    }
}
