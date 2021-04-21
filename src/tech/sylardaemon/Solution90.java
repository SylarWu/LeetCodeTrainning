package tech.sylardaemon;

import java.util.*;

public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp;
        String x;
        List<List<Integer>> res = new LinkedList<>();
        Map<String,Boolean> mark = new HashMap<>();
        int n = nums.length;
        for (int mask = 0;mask < (1 << n); ++mask){
            temp = new LinkedList<>();
            for (int i = 0; i < n ; ++i){
                if ((mask & (1 << i)) != 0){
                    temp.add(nums[i]);
                }
            }
            x = this.setToString(temp);
            if (!mark.containsKey(x)){
                mark.put(x,true);
                res.add(temp);
            }

        }
        return res;
    }

    private String setToString(List<Integer> list){
        StringBuilder temp = new StringBuilder();
        for (Integer x : list){
            temp.append(x);
            temp.append(",");
        }
        return temp.toString();
    }
}
