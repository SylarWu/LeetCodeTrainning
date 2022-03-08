package tech.sylardaemon;

public class Solution2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; ++i){
            sum += (s.charAt(i) == '*' ? 1 : 0);
            preSum[i] += sum;
        }
        for (int i = 0, left = -1; i < n; ++i){
            left = s.charAt(i) == '|' ? i : left;
            leftCandle[i] = left;
        }
        for (int i = n - 1, right = -1; i >= 0; --i){
            right = s.charAt(i) == '|' ? i : right;
            rightCandle[i] = right;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < result.length; ++i){
            int left = rightCandle[queries[i][0]];
            int right = leftCandle[queries[i][1]];
            result[i] = (left == -1 || right == -1 || left > right ? 0 : preSum[right] - preSum[left]);
        }
        return result;
    }

    private int[] brutalForceMethod(String s, int[][] queries){
        char[] data = s.toCharArray();
        int[] lastCandle = new int[data.length];
        int last = -1;
        for (int i = 0; i < data.length; ++i){
            lastCandle[i] = last;
            last = data[i] == '|' ? i : last;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i){
            result[i] = getAnswer(data, lastCandle, queries[i][0], queries[i][1]);
        }
        return result;
    }
    private int getAnswer(char[] data, int[] lastCandle, int left, int right){
        int result = 0;
        while (left < right){
            int before = lastCandle[right];
            if (data[right] == '|' && before >= left){
                result += (right - before - 1);
            }
            right = before;
        }
        return result;
    }
}
