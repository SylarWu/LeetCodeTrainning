package tech.sylardaemon.offer;

public class Solution56 {
    public int[] singleNumbers(int[] nums) {
        int a_xor_b = 0;
        for (int i = 0; i < nums.length; ++i){
            a_xor_b ^= nums[i];
        }
        int m = 1;
        while ((m & a_xor_b) == 0){
            m <<= 1;
        }
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; ++i){
            if ((nums[i] & m) == 0){
                x ^= nums[i];
            }else{
                y ^= nums[i];
            }
        }
        return new int[]{x, y};
    }
}
