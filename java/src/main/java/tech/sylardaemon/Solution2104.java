package tech.sylardaemon;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2104 {
    public long subArrayRanges(int[] nums) {
        int[] minLeft = new int[nums.length];
        int[] minRight = new int[nums.length];
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];
        LinkedList<Integer> minStack = new LinkedList<>();
        LinkedList<Integer> maxStack = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i){
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        minStack.clear();
        maxStack.clear();
        for (int i = nums.length - 1; i >= 0; --i){
            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]){
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty() ? nums.length : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]){
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty() ? nums.length : maxStack.peek();
            maxStack.push(i);
        }
        long sumMax = 0, sumMin = 0;
        for (int i = 0; i < nums.length; ++i){
            sumMax += ((long)(i - maxLeft[i]) * (maxRight[i] - i)) * nums[i];
            sumMin += ((long)(i - minLeft[i]) * (minRight[i] - i)) * nums[i];
        }
        return sumMax - sumMin;
    }

    private long brutalForceMethod(int[] nums){
        long result = 0;
        for (int i = 0; i < nums.length; ++i){
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < nums.length; ++j){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                result += (max - min);
            }
        }
        return result;
    }

    private long dpMethod(int[] nums){
        long result = 0;
        int[][][] dp = new int[nums.length][nums.length][2];
        for (int i = 0; i < nums.length; ++i){
            dp[i][i][0] = dp[i][i][1] = nums[i];
        }
        for (int i = 1; i < nums.length; ++i){
            for (int j = 0; j < nums.length - i; ++j){
                dp[j][j + i][0] = Math.min(dp[j][j + i - 1][0], nums[j + i]);
                dp[j][j + i][1] = Math.max(dp[j][j + i - 1][1], nums[j + i]);
            }
        }
        for (int i = 0; i < nums.length; ++i){
            for (int j = i + 1; j < nums.length; ++j){
                result += (dp[i][j][1] - dp[i][j][0]);
            }
        }
        return result;
    }
}
