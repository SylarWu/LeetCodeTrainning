package tech.sylardaemon;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1){
            return n;
        }
        int count = 0;
        for (int i = 1; i < n; ++i){
            if (nums[count] == nums[i]){
                continue;
            }
            ++count;
            nums[count] = nums[i];
        }
        return count + 1;
    }
}
