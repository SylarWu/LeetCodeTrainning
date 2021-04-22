package tech.sylardaemon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if (n < 3){
            return res;
        }
        int b,c;
        Arrays.sort(nums);
        for (int a = 0; a < nums.length ; ++a){
            if (nums[a] > 0){
                break;
            }
            if (a > 0 && nums[a] == nums[a - 1]){
                continue;
            }
            b = a + 1;
            c = n - 1;
            while (b < c){
                if (b > a + 1 && nums[b] == nums[b - 1]){
                    ++b;
                    continue;
                }
                if (c < n - 1 && nums[c] == nums[c + 1]){
                    --c;
                    continue;
                }
                if (nums[a] + nums[b] + nums[c] == 0){
                    List<Integer> temp = new LinkedList<>();
                    temp.add(nums[a]);
                    temp.add(nums[b]);
                    temp.add(nums[c]);
                    res.add(temp);
                    ++b;
                    --c;
                }else if (nums[a] + nums[b] + nums[c] > 0){
                    --c;
                }else{
                    ++b;
                }
            }
        }
        return res;
    }
}
