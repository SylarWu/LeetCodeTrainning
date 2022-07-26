package tech.sylardaemon.offer;

public class Solution14 {
    public int cuttingRope(int n) {
        return greedy(n);
    }

    private int dp(int n){
        /* dp[i]为长度为i的绳切成m段最大乘积, 长度为1最大乘积为1 */
        /* 转移方程: 1. dp[i] = dp[j] * (i - j), m = dp[j]切的段数+1 */
        /* 转移方程: 2. dp[i] = j * (i - j), m = 2 */
        /* 两者最大 */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i){
            for (int j = 1; j < i; ++j){
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));
            }
        }
        return dp[n];
    }

    private int greedy(int n){
        final int MODE = 1000000007;
        if (n <= 3){
            return n - 1;
        }
        long result = 1;
        while (n > 4){
            result = result * 3 % MODE;
            n -= 3;
        }
        return (int) (result * n % MODE);
    }

}
