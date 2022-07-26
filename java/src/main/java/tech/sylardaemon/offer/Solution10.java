package tech.sylardaemon.offer;

public class Solution10 {
    public int fib(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        final int MODE = 1000000007;
        int a = 0, b = 1;
        int c = a + b;
        for (int i = 1; i < n; ++i){
            c = (a + b) % MODE;
            a = b;
            b = c;
        }
        return c;
    }
    public int numWays(int n) {
        if (n < 2){
            return 1;
        }
        final int MODE = 1000000007;
        int a = 1, b = 1;
        int c = a + b;
        for (int i = 1; i < n; ++i){
            c = (a + b) % MODE;
            a = b;
            b = c;
        }
        return c;
    }
}
