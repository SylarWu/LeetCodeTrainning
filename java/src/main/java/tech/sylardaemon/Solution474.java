package tech.sylardaemon;

public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs){
            int[] zeroAndone = countZeroOne(s);
            int zero = zeroAndone[0];
            int one = zeroAndone[1];
            for (int i = m; i >= zero; --i){
                for (int j = n; j >= one; --j){
                    dp[i][j] = dp[i][j] > (dp[i - zero][j - one] + 1) ? dp[i][j] : (dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] countZeroOne(String s){
        int[] res = new int[2];
        for (int i = 0; i < s.length();++i){
            if (s.charAt(i) == '0'){
                ++res[0];
            }else{
                ++res[1];
            }
        }
        return res;
    }

}
