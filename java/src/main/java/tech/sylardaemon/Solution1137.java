package tech.sylardaemon;

public class Solution1137 {

    private static int[] lookup;

    private static final int maxN = 38;

    static {
        lookup = new int[maxN];
        lookup[0] = 0;
        lookup[1] = 1;
        lookup[2] = 1;
        for (int i = 3; i < maxN; ++i){
            lookup[i] = lookup[i - 1] + lookup[i - 2] + lookup[i - 3];
        }
    }

    public int tribonacci(int n) {
        return lookup[n];
    }

}
