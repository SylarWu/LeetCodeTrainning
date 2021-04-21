package tech.sylardaemon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        return hashMapMethod(nums);
    }

    private boolean hashMapMethod(int[] nums){
        Map<Integer,Integer> mark = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            if (!mark.containsKey(nums[i])){
                mark.put(nums[i],i);
            }else{
                return true;
            }
        }
        return false;
    }



    private boolean sortMethod(int[] nums){
        mergeSort(nums,new int[nums.length],0,nums.length - 1);
        for (int i = 1; i < nums.length ; ++i){
            if (nums[i] == nums[i - 1]){
                return true;
            }
        }
        return false;
    }

    private void mergeSort(int[] nums,int[] temp,int begin,int end){
        if (begin < end){
            int mid = (begin + end) / 2;
            mergeSort(nums,temp,begin,mid);
            mergeSort(nums,temp,mid + 1,end);
            merge(nums,temp,begin,mid,end);
        }
    }

    private void merge(int[] nums,int[] temp,int begin,int mid,int end){
        for (int i = begin; i <= end; ++i){
            temp[i] = nums[i];
        }
        int i = begin, j = mid + 1;
        for (int k = begin; k <= end; ++k){
            if (i > mid){
                nums[k] = temp[j];
                ++j;
            }else if (j > end){
                nums[k] = temp[i];
                ++i;
            }else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                ++i;
            }else{
                nums[k] = temp[j];
                ++j;
            }
        }
    }
}
