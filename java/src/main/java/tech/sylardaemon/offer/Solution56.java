package tech.sylardaemon.offer;

public class Solution56 {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int x : nums){
            xor ^= x;
        }
        int mask = 1;
        while ( (xor & mask) == 0){
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int x : nums){
            if ((mask & x) != 0){
                a ^= mask;
            }else{
                b ^= mask;
            }
        }
        return new int[]{a,b};
    }
}
