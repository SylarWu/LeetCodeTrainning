package tech.sylardaemon;

public class Solution1769 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] countRight = new int[n];
        int[] countLeft = new int[n];
        int count = 0;
        if (boxes.charAt(n - 1) == '1'){
            ++count;
        }
        for (int i = n - 2; i >= 0; --i){
            countRight[i] = countRight[i + 1] + count;
            if (boxes.charAt(i) == '1'){
                ++count;
            }
        }
        count = 0;
        if (boxes.charAt(0) == '1'){
            ++count;
        }
        for (int i = 1; i < n ; ++i){
            countLeft[i] = countLeft[i - 1] + count;
            if (boxes.charAt(i) == '1'){
                ++count;
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; ++i){
            result[i] = countLeft[i] + countRight[i];
        }
        return result;
    }
}
