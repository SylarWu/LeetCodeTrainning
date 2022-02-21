package tech.sylardaemon;

public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }else if (n == 2){
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int haveFirst = robRange(nums,0,n - 2);
        int noFirst = robRange(nums,1,n - 1);
        return haveFirst > noFirst ? haveFirst : noFirst;
    }

    private int robRange(int[] nums,int begin,int end){
        int beforeTwo = nums[begin];
        int beforeOne = nums[begin] > nums[begin + 1] ? nums[begin] : nums[begin + 1];
        int temp = beforeOne > beforeTwo ? beforeOne : beforeTwo;
        for (int i = begin + 2; i <= end; ++i){
            temp = beforeTwo + nums[i] > beforeOne ? beforeTwo + nums[i] : beforeOne;
            beforeTwo = beforeOne;
            beforeOne = temp;
        }
        return temp;
    }
}
