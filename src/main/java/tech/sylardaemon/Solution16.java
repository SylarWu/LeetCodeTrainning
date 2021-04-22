package tech.sylardaemon;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        int minimum = abs(res - target);
        int gap = res - target;
        for (int i = 0; i < n - 2; ++i){
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                gap = nums[i] + nums[j] + nums[k] - target;
                if (abs(gap) < minimum){
                    minimum = abs(gap);
                    res = nums[i] + nums[j] + nums[k];
                }
                if (gap < 0){
                    ++j;
                }else{
                    --k;
                }
            }
        }
        return res;
    }

    private int abs(int x){
        return x < 0 ? -x : x;
    }
}
