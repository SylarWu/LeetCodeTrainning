package tech.sylardaemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        dfs1(candidates,0,target,new LinkedList<Integer>(),res);
        return res;
    }

    private void dfs1(int[] candidates,int begin,int target,LinkedList<Integer> temp,List<List<Integer>> res){
        if (target < 0){
            return;
        }else if (target == 0){
            res.add(new LinkedList<>(temp));
            return;
        }
        for (int i = begin; i < candidates.length; ++i){
            if (target - candidates[i] < 0){
                break;
            }
            temp.addLast(candidates[i]);
            dfs1(candidates,i + 1,target - candidates[i],temp,res);
            temp.removeLast();
        }
    }
}
