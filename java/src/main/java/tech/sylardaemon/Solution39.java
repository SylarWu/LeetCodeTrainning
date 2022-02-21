package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        quickSort(candidates,0,candidates.length - 1);
        dfs2(candidates,target,0,new LinkedList<Integer>(),res);
        return res;
    }

    private void dfs1(int[] candidates,int target,int begin,LinkedList<Integer> temp,List<List<Integer>> res){
        if (begin == candidates.length){
            return;
        }
        if (target == 0){
            res.add((List<Integer>) temp.clone());
            return;
        }
        dfs1(candidates,target,begin + 1,temp,res);
        if (target - candidates[begin] >= 0){
            temp.addLast(candidates[begin]);
            dfs1(candidates,target - candidates[begin],begin,temp,res);
            temp.removeLast();
        }
    }

    private void dfs2(int[] candidates,int target,int begin,LinkedList<Integer> temp,List<List<Integer>> res){
        if (target < 0){
            return;
        }else if (target == 0){
            res.add((List<Integer>) temp.clone());
            return;
        }
        for (int i = begin; i < candidates.length ;++i){
            if (target - candidates[i] < 0){
                break;
            }
            temp.addLast(candidates[i]);
            dfs2(candidates,target - candidates[i],i,temp,res);
            temp.removeLast();
        }
    }

    private void quickSort(int[] nums,int left,int right){
        if (left >= right){
            return;
        }
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && nums[j] > pivot){
                --j;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot){
                ++i;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums,left,i - 1);
        quickSort(nums,i + 1,right);
    }


    private void print(List<Integer> list){
        for (int x : list){
            System.out.print(String.valueOf(x) + ",");
        }
        System.out.println();
    }
}
