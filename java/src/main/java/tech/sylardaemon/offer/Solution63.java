package tech.sylardaemon.offer;

public class Solution63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1){
            return 0;
        }
        int lowest = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; ++i){
            lowest = Math.min(lowest, prices[i]);
            result = Math.max(result, prices[i] - lowest);
        }
        return result;
    }
}
