package tech.sylardaemon;

import java.util.HashMap;

public class Solution403 {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1){
            return false;
        }
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[1][1] = true;
        int k;
        for (int i = 2; i < stones.length; ++i){
            for (int j = 1; j < i; ++j){
                k = stones[i] - stones[j];
                if (k <= j + 1){
                    dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                }
            }
        }

        for (int i = 1; i < stones.length; ++i){
            if (dp[stones.length - 1][i]){
                return true;
            }
        }
        return false;
    }

}
