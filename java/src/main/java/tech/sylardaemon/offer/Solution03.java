package tech.sylardaemon.offer;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution03 {

    public int findRepeatNumber(int[] nums) {
        int index = 0;
        while (index < nums.length){
            if (index == nums[index]){
                ++index;
                continue;
            }
            if (nums[index] == nums[nums[index]]){
                return nums[index];
            }
            int temp = nums[index];
            nums[index] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }


    private int firstIdea(int[] nums){
        final Object PLACEHOLDER = new Object();
        HashMap<Integer, Object> memory = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            if (memory.containsKey(nums[i])){
                return nums[i];
            }
            memory.put(nums[i], PLACEHOLDER);
        }
        return -1;
    }
}
