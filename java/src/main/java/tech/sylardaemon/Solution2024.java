package tech.sylardaemon;

public class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getCnt(answerKey, 'T', k), getCnt(answerKey, 'F', k));
    }
    private int getCnt(String str, char c, int k){
        int n = str.length();
        int result = 0;
        int count = 0;
        for (int left = 0, right = 0; right < n; ++right){
            if (str.charAt(right) == c){
                ++count;
            }
            while (count > k){
                count -= str.charAt(left) == c ? 1 : 0;
                ++left;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
