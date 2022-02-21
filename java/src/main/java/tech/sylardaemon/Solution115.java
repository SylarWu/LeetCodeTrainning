package tech.sylardaemon;

public class Solution115 {

    public int numDistinct(String s, String t) {
        if (s.length() < t.length() || s.length() == 0 || t.length() == 0){
            return 0;
        }
        if (s.equals(t)){
            return 1;
        }
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[n][m];
        if (s.charAt(0) == t.charAt(0)){
            dp[0][0] = 1;
        }
        for (int j = 1; j < m; ++j){
            if (s.charAt(j) == t.charAt(0)){
                dp[0][j] = dp[0][j - 1] + 1;
            }else{
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1;i < n; ++i){
            for (int j = 1; j < m; ++j){
                if (s.charAt(j) == t.charAt(i)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
