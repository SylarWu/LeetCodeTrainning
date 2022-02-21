package tech.sylardaemon;

import java.util.Arrays;

public class Solution457 {
    public boolean circularArrayLoop(int[] nums) {
        return sfPointer(nums);
    }


    private boolean sfPointer(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int slow, fast;
        int temp;
        for (int i = 0; i < nums.length; ++i) {
            slow = i;
            fast = nextIndex(nums, i);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[nextIndex(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == nextIndex(nums, slow)) {
                        break;
                    } else {
                        return true;
                    }
                }
                slow = nextIndex(nums, slow);
                fast = nextIndex(nums, nextIndex(nums, fast));
            }
            slow = i;
            while (nums[slow] * nums[nextIndex(nums, slow)] > 0){
                temp = slow;
                slow = nextIndex(nums,slow);
                nums[temp] = 0;
            }
            nums[slow] = 0;
        }
        return false;
    }


    private boolean simpleSolution(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        boolean pos;
        int maxLoop = nums.length;
        int next;
        int step;
        for (int i = 0; i < nums.length; ++i) {
            pos = nums[i] > 0;
            next = nextIndex(nums, i);
            if (next == i) {
                continue;
            }
            step = 2;
            while ((nums[next] > 0 && pos) || (nums[next] < 0 && !pos)) {
                if (next == i) {
                    return true;
                }
                if (step > maxLoop) {
                    break;
                }
                next = nextIndex(nums, next);
                ++step;
            }
        }
        return false;
    }

    private int nextIndex(int[] nums, int cur) {
        return ((cur + nums[cur]) % nums.length + nums.length) % nums.length;
    }

}
