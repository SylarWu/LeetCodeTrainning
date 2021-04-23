package tech.sylardaemon;

import tech.sylardaemon.basic.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        return firstThought(nums);
    }

    private List<Integer> firstThought(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer>[] dp = new ArrayList[n];
        int maxindex;
        int maxcount;
        List<Integer> res = null;
        for (int i = 0 ; i < n; ++i){
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
            maxindex = -1;
            maxcount = 0;
            for (int j = 0; j < i; ++j){
                if (nums[i] % nums[j] == 0 && dp[j].size() > maxcount){
                    maxindex = j;
                    maxcount = dp[j].size();
                }
            }
            if (maxindex != -1){
                dp[i].addAll(dp[maxindex]);
            }
            if (res == null || res.size() < dp[i].size()){
                res = dp[i];
            }
        }
        return res;
    }
}
