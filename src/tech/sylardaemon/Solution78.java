package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution78 {

    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.res.clear();
        this.temp.clear();
        backTrace(nums,0);
        return res;
    }


    private void backTrace(int[] nums,int start){
        this.res.add((List<Integer>) this.temp.clone());
        for (int i = start; i < nums.length; ++i){
            this.temp.add(nums[i]);
            backTrace(nums,i + 1);
            this.temp.remove(this.temp.size() - 1);
        }
    }

    private List<List<Integer>> iteration(int[] nums){
        List<Integer> temp;
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); ++mask){
            temp = new LinkedList<>();
            for (int i = 0; i < n ; ++i){
                if ((mask & (1 << i)) != 0){
                    temp.add(nums[i]);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
