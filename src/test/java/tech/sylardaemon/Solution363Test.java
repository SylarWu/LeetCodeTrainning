package tech.sylardaemon;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class Solution363Test {

    @Test
    public void maxSumSubmatrix() {
        int[][] testCase = new int[][]{{2,2,-1}};
        Solution363 solution363 = new Solution363();
        int res = solution363.maxSumSubmatrix(testCase,0);
        Assert.assertEquals(res,-1);
    }
}
