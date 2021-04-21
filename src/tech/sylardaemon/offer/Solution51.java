package tech.sylardaemon.offer;

public class Solution51 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        int[] input = new int[nums.length];
        for (int i = 0 ; i < nums.length ; ++i){
            input[i] = nums[i];
        }
        return mergeSort(input,new int[nums.length],0,nums.length - 1);
    }

    private int mergeSort(int[] nums,int[] target,int l,int r){
        if (l == r){
            return 0;
        }
        int middle = (l + r) / 2;
        int leftCount = mergeSort(nums,target,l,middle);
        int rightCount = mergeSort(nums,target,middle + 1,r);
        if (nums[middle] <= nums[middle + 1]){
            return leftCount + rightCount;
        }
        return leftCount + rightCount + merge(nums,target,l,middle,r);
    }

    private int merge(int[] nums,int[] target,int l,int middle,int r){
        for (int i = l; i <= r; ++i){
            target[i] = nums[i];
        }
        int i = l;
        int j = middle + 1;
        int pair_count = 0;
        for (int k = l; k <= r; ++k){
            if (i == middle + 1){
                nums[k] = target[j++];
            }else if (j == r + 1){
                nums[k] = target[i++];
            }else if (target[i] <= target[j]){
                nums[k] = target[i++];
            }else{
                nums[k] = target[j];
                pair_count += (middle + 1 - i);
                ++j;
            }
        }
        return pair_count;
    }

}
