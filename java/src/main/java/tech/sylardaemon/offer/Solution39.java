package tech.sylardaemon.offer;

public class Solution39 {
    public int majorityElement(int[] nums) {
        int mode = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; ++i){
            if (mode != nums[i]){
                --vote;
            }else{
                ++vote;
            }
            if (vote == 0){
                mode = nums[i];
                vote = 1;
            }
        }
        return mode;
    }
}
