package tech.sylardaemon;

public class Solution191 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; ++i){
            if ( (n & 0x00000001) == 1){
                ++count;
            }
            n = n >> 1;
        }
        return count;
    }
}
