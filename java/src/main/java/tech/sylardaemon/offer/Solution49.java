package tech.sylardaemon.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution49 {
    public int nthUglyNumber(int n) {
        return heap_method(n);
    }

    private int heap_method(int n){
        int[] factors = new int[]{2, 3, 5};
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        int result = 1;
        for (int i = 0; i < n; ++i){
            long temp = queue.poll();
            result = (int) temp;
            for (int factor: factors){
                if (set.add(temp * factor)){
                    queue.offer(temp * factor);
                }
            }
        }
        return result;
    }

    private int dp_method(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; ++i){
            int n_a = dp[a] * 2, n_b = dp[b] * 3, n_c = dp[c] * 5;
            dp[i] = Math.min(n_a, Math.min(n_b, n_c));
            if (dp[i] == n_a){
                ++a;
            }
            if (dp[i] == n_b){
                ++b;
            }
            if (dp[i] == n_c){
                ++c;
            }
        }
        return dp[n - 1];
    }
}
