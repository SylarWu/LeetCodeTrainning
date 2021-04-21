package tech.sylardaemon;

public class Solution263 {
    private final int[] factor = new int[]{2,3,5};

    public boolean isUgly(int n) {
        if (n <= 0){
            return false;
        }
        boolean isBreak;
        while (n != 1){
            isBreak = true;
            for (int i = 0; i < factor.length; ++i){
                if (n % factor[i] == 0){
                    n = n / factor[i];
                    isBreak = false;
                }
            }
            if (isBreak){
                break;
            }
        }
        return n == 1;
    }
}
