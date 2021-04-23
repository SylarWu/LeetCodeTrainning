package tech.sylardaemon;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        return dpMethod(nums);
    }

    private int dpMethod(int[] nums){
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int pre = 0;
        int maxi = nums[0];
        for (int i = 0; i < n; ++i){
            pre = (pre + nums[i]) > nums[i] ? (pre + nums[i]) : nums[i];
            maxi = pre > maxi ? pre : maxi;
        }
        return maxi;
    }

    private int bruteForce(int[] nums){
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        int[] sums = new int[n];
        sums[0] = nums[0];
        int maxi = Integer.MIN_VALUE;
        for (int i = 1; i < n; ++i){
            sums[i] = sums[i - 1] + nums[i];
        }
        for (int i = 1; i < n; ++i){
            maxi = sums[i] > maxi ? sums[i] : maxi;
            for (int ii = 1; ii < i; ++ii){
                maxi = (sums[i] - sums[ii - 1]) > maxi ? (sums[i] - sums[ii - 1]) : maxi;
            }
        }
        return maxi;
    }
}
