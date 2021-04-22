package tech.sylardaemon;

import java.util.TreeMap;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return false;
        }
        int leftMin = nums[0];
        TreeMap<Integer,Integer> rightAll = new TreeMap<>();
        for (int k = 2; k < n; ++k){
            rightAll.put(nums[k],rightAll.getOrDefault(nums[k],0) + 1);
        }
        for (int j = 1; j < n - 1; ++j){
            if (leftMin < nums[j]){
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && nums[j] > next){
                    return true;
                }
            }
            leftMin = nums[j] < leftMin ? nums[j] : leftMin;
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }
        return false;
    }
}
