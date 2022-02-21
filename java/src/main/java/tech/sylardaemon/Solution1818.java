package tech.sylardaemon;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        final long mod = 1000000007L;

        long total = 0;

        for (int i = 0; i < nums1.length; ++i) {
            total += abs(nums1[i] - nums2[i]);
        }

        total += findReplacement(nums1, nums2);

        return (int) (total % mod);
    }

    private int findReplacement(int[] nums1, int[] nums2) {
        int[] sorted = Arrays.copyOf(nums1, nums1.length);
        Arrays.sort(sorted);
        int mini = 0;
        int searchIndex = 0;
        int afterChange = 0;
        for (int i = 0; i < nums1.length; ++i) {
            if (nums1[i] == nums2[i]){
                continue;
            }
            searchIndex = bisearch(sorted, nums2[i]);
            afterChange = abs(sorted[searchIndex] - nums2[i]) - abs(nums1[i] - nums2[i]);
            if (afterChange < mini) {
                mini = afterChange;
            }
        }
        return mini;
    }

    private int bisearch(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;

        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }else if (nums[middle] < target) {
                begin = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (begin < 0 || end < 0){
            return 0;
        }else if (begin >= nums.length || end >= nums.length){
            return nums.length - 1;
        }else {
            return abs(nums[begin] - target) < abs(nums[end] - target) ? begin : end;
        }
    }


    private int abs(int x) {
        return x >= 0 ? x : -x;
    }
}
