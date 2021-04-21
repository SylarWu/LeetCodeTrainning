package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        LinkedList<Integer>[] hash = new LinkedList[1000];
        for (int i = 0 ; i < 1000 ;++i){
            hash[i] = new LinkedList<Integer>();
        }
        int index = 0;
        for (int i = 0; i < nums.length; ++i){
            index = nums[i] % 1000;
            for (Integer x : hash[index]){
                if (x == nums[i]){
                    return x;
                }
            }
            hash[index].add(nums[i]);
        }
        return 0;
    }
}
