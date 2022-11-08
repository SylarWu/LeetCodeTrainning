package tech.sylardaemon.offer;

import java.util.LinkedList;
import java.util.List;

public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right= nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] > target){
                --right;
            }else if (nums[left] + nums[right] < target){
                ++left;
            }else{
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }

    public int[][] findContinuousSequence(int target) {
        return two_pointer_method(target);
    }

    private int[][] two_pointer_method(int target) {
        int left = 1, right = 2;
        List<int[]> result = new LinkedList<>();
        while (left < right){
            int sum = (left + right) * (right - left + 1);
            if (sum > 2 * target){
                ++left;
            }else if (sum < 2 * target){
                ++right;
            }else{
                int[] temp = new int[right - left + 1];
                for (int i = 0; i < temp.length; ++i){
                    temp[i] = left + i;
                }
                result.add(temp);
                ++left;
            }
        }
        return result.toArray(new int[0][]);
    }

    private int[][] simple_method(int target){
        List<int[]> result = new LinkedList<>();
        int begin = 1;
        while (begin < target){
            int end = begin + 1;
            while ((begin + end)* (end - begin + 1) < 2 * target){
                ++end;
            }
            if ((begin + end)* (end - begin + 1) == 2 * target){
                int[] temp = new int[end - begin + 1];
                for (int i = 0; i < temp.length; ++i){
                    temp[i] = begin + i;
                }
                result.add(temp);
            }
            ++begin;
        }
        int[][] final_result = new int[result.size()][];
        int i = 0;
        for (int[] temp: result){
            final_result[i++] = temp;
        }
        return final_result;
    }
}
