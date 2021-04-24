package tech.sylardaemon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution377Test {

    @Test
    public void combinationSum4() {
        int[] nums = new int[]{1,2,3};
        int target = 4;
        Solution377 solution377 = new Solution377();
        Assert.assertEquals(7,solution377.combinationSum4(nums,target));
    }
}