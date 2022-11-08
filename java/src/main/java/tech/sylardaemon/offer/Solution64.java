package tech.sylardaemon.offer;

public class Solution64 {
    public int sumNums(int n) {
        boolean temp = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
