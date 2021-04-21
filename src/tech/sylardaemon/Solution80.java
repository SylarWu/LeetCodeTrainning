package tech.sylardaemon;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int slow = 2;
        int fast = 2;
        if (nums.length <= 2){
            return nums.length;
        }
        while (fast < nums.length){
            if (nums[fast] != nums[slow - 2]){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    private int firtInMyHead(int[] nums){
        int cur = 0;
        int limit = 1;
        int i = 1;
        while (true){
            while (i < nums.length && nums[cur] == nums[i]){
                ++limit;
                ++i;
            }
            if (limit >= 2){
                nums[cur + 1] = nums[cur];
                cur = cur + 2;
            }else{
                cur = cur + 1;
            }
            if (cur >= nums.length || i >= nums.length){
                break;
            }
            nums[cur] = nums[i];
            limit = 1;
            ++i;
        }
        return cur;
    }
}
