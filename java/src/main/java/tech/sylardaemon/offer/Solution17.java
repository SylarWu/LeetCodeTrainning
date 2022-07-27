package tech.sylardaemon.offer;

public class Solution17 {
    public int[] returnNumbers(int n) {
        int upper_bound = 1;
        while (n > 0){
            upper_bound *= 10;
            --n;
        }
        int[] result = new int[upper_bound - 1];
        for (int i = 1; i < upper_bound; ++i){
            result[i - 1] = i;
        }
        return result;
    }


    public void printNumbers(int n){
        StringBuffer result = new StringBuffer();
        char[] num = new char[n];
        dfs(result, num, 0, n);
        System.out.println(result.substring(0, result.length() - 1));
    }

    private void dfs(StringBuffer result, char[] num, int index, int n){
        final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        if (index == n){
            int i = 0;
            while (num[i] == '0' && i < n - 1) {
                ++i;
            }
            while (i < n){
                result.append(num[i++]);
            }
            result.append(',');
            return;
        }
        for (char digit: digits){
            num[index] = digit;
            dfs(result, num, index + 1, n);
        }
    }
}
