package tech.sylardaemon;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution368Test {

    @Test
    public void largestDivisibleSubset() {
        int[] testCase = new int[]{1,2,4,8};
        Solution368 solution368 = new Solution368();
        List<Integer> actual = solution368.largestDivisibleSubset(testCase);
        for (int x : actual){
            System.out.print(x);
            System.out.print(",");
        }
    }
}