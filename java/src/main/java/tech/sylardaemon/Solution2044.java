package tech.sylardaemon;

import java.util.HashMap;
import java.util.Map;

public class Solution2044 {
    private static Map<Integer, Integer> MAPPING;
    static {
        MAPPING = new HashMap<>();
        for (int i = 0; i < 16; ++i){
            MAPPING.put(1 << i, i);
        }
    }


    public int countMaxOrSubsets(int[] nums) {
        return dfsMethod(nums);
    }

    private int brutalForceMethod(int[] nums){
        int maxOr = 0;
        int maxCount = 0;
        for (int i = 0; i < (1 << nums.length); ++i){
            int temp = 0;
            for (int j = 0; j < nums.length; ++j){
                if (((i >> j) & 1) == 1){
                    temp |= nums[j];
                }
            }
            if (temp > maxOr){
                maxOr = temp;
                maxCount = 1;
            }else if (temp == maxOr){
                ++maxCount;
            }
        }
        return maxCount;
    }
    private int lowbit(int x){
        return -x & x;
    }

    private int dpMethod(int[] nums){
        int maxOr = 0;
        int maxCount = 0;
        int[] dp = new int[1 << nums.length];
        for (int i = 1; i < (1 << nums.length); ++i){
            dp[i] = dp[i - lowbit(i)] | nums[MAPPING.get(lowbit(i))];
            if (dp[i] > maxOr){
                maxOr = dp[i];
                maxCount = 1;
            }else if (dp[i] == maxOr){
                ++maxCount;
            }
        }
        return maxCount;
    }

    private int maxOr = 0;
    private int maxCount = 0;
    private int dfsMethod(int[] nums){
        maxOr = 0;
        maxCount = 0;
        dfs(nums, 0, 0);
        return maxCount;
    }
    private void dfs(int[] nums, int index, int val){
        if (index == nums.length){
            if (val > maxOr){
                maxOr = val;
                maxCount = 1;
            }else if (val == maxOr){
                ++maxCount;
            }
            return;
        }
        dfs(nums, index + 1, val);
        dfs(nums, index + 1, nums[index] | val);
    }
}
