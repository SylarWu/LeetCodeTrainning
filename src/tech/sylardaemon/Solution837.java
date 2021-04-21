package tech.sylardaemon;

public class Solution837 {
    public double new21Game(int N, int K, int W) {
        if ( (K + W) <= (N + 1)){
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int k = K ; k <= N ;++k){
            dp[k] = 1.0;
        }
        double sumProb = N - K + 1;
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sumProb / W;
            sumProb = sumProb - dp[i + W] + dp[i];
        }
        return dp[0];
    }
}
