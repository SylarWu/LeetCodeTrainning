package tech.sylardaemon;

import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int i = 0; i < costs.length; ++i){
            if (costs[i] <= coins){
                ++count;
                coins -= costs[i];
            }else{
                break;
            }
        }
        return count;
    }
}
