package tech.sylardaemon;


public class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (n + m);
        int afterTotal = sum(rolls);
        int beforeTotal = total - afterTotal;
        if (beforeTotal < n || beforeTotal > 6 * n){
            return new int[0];
        }
        int[] result = new int[n];
        int beforeMean = beforeTotal / n;
        int beforeMod = beforeTotal % n;
        for (int i = 0; i < n; ++i){
            result[i] = beforeMean;
            while (result[i] < 6 && beforeMod != 0){
                ++result[i];
                --beforeMod;
            }
        }
        return result;
    }

    private int sum(int[] rolls){
        int result = 0;
        for (int x : rolls){
            result += x;
        }
        return result;
    }
}
