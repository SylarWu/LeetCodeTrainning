package tech.sylardaemon;

public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return 0;
        }
        int count = 0;
        int i = 0, j;
        int seqLen;
        while ( i < n - 2){
            j = i + 1;
            while (j < n - 1 && nums[j] - nums[j - 1] == nums[j + 1] - nums[j]){
                ++j;
            }
            seqLen = j - i + 1;
            while (seqLen >= 3){
                count += (seqLen - 2);
                --seqLen;
            }
            i = j;
        }
        return count;
    }
}
