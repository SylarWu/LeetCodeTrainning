package tech.sylardaemon;

public class Solution70 {
    private static final int maxN = 1000;
    private static final int[] cache = new int[maxN];
    private static int cur;

    static {
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        cur = 2;
    }


    public int climbStairs(int n) {
        int a = 0, b = 1, c = 2;
        if (n == 0 || n == 1 || n == 2){
            return n;
        }
        for (int i = 2; i < n; ++i){
            a = b + c;
            b = c;
            c = a;
        }
        return c;
    }


    private int cachebase(int n){
        if (n != 0 && n != 1 && cache[n] == 0) {
            for (int i = cur + 1; i <= n; ++i) {
                cache[i] = cache[i - 1] + cache[i - 2];
            }
            cur = n;
        }
        return cache[n];
    }
}
