package tech.sylardaemon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return bucketMethod(nums,k,t);
    }

    private boolean firstInMyHead(int[] nums,int k, int t){
        TreeSet<Long> mark = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i){
            Long ceiling = mark.ceiling((long) nums[i] - (long)t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t){
                return true;
            }
            mark.add((long) nums[i]);
            if (mark.size() > k){
                mark.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    private boolean bucketMethod(int[] nums, int k, int t){
        Map<Long,Long> bucket = new HashMap<>();
        int range = t + 1;
        long index;
        for (int i = 0; i < nums.length; ++i){
            index = getIndex((long) nums[i],range);
            if (bucket.containsKey(index)){
                return true;
            }else if (bucket.containsKey(index - 1) && Math.abs(bucket.get(index - 1) - nums[i]) <= (long)t){
                return true;
            }else if (bucket.containsKey(index + 1) && Math.abs(bucket.get(index + 1) - nums[i]) <= (long)t){
                return true;
            }
            bucket.put(index,(long) nums[i]);
            if (bucket.size() > k){
                bucket.remove(getIndex((long)nums[i - k],range));
            }
        }
        return false;
    }

    private long getIndex(long x,long range){
        return x >= 0 ? (x / range) : ((x + 1) / range - 1);
    }
}
