package tech.sylardaemon;

public class Solution5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (s == null || n < 1){
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int start = 0,end = 0;
        for (int i = 0; i < n; ++i){
            dp[i][i] = true;
        }
        for (int i = n - 1; i >= 0; --i){
            for (int j = i + 1; j < n; ++j){
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && (j - i) > (end - start)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private String expandCenterMethod(String s){
        int n = s.length();
        if (s == null || n < 1){
            return "";
        }
        int start = 0, end = 0;
        int s_start, s_end;
        int bi_start,bi_end;
        for (int i = 0; i < n; ++i){
            s_start = s_end = i;
            bi_start = i;
            bi_end = i + 1;
            while (s_start >= 0 && s_end < n && (s.charAt(s_start) == s.charAt(s_end))){
                --s_start;
                ++s_end;
            }
            ++s_start;
            --s_end;
            while (bi_start >= 0 && bi_end < n && (s.charAt(bi_start) == s.charAt(bi_end))){
                --bi_start;
                ++bi_end;
            }
            ++bi_start;
            --bi_end;
            if ((s_end - s_start) > (end - start)){
                start = s_start;
                end = s_end;
            }
            if ((bi_end - bi_start) > (end - start)){
                start = bi_start;
                end = bi_end;
            }
        }
        return s.substring(start,end + 1);
    }
}
