package tech.sylardaemon;

public class Solution509 {
    public int fib(int n) {
        int a = 0, b = 1, c = 1;
        if (n == 0 || n == 1){
            return n;
        }
        for (int i = 2; i < n; ++i){
            a = b + c;
            b = c;
            c = a;
        }
        return c;
    }
}
