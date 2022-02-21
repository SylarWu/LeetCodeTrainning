package tech.sylardaemon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return hashSetMethod(nums,k);
    }

    private boolean firstInMyHead(int[] nums, int k){
        Map<Integer,Integer> mark = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            if (mark.containsKey(nums[i]) && (i - mark.get(nums[i]) <= k)){
                return true;
            }
            mark.put(nums[i],i);
        }
        return false;
    }

    private boolean hashSetMethod(int[] nums,int k){
        Set<Integer> mark = new HashSet<>();
        for (int i = 0; i < nums.length; ++i){
            if (mark.contains(nums[i])){
                return true;
            }
            mark.add(nums[i]);
            if (mark.size() > k){
                mark.remove(nums[i - k]);
            }
        }
        return false;
    }
}
