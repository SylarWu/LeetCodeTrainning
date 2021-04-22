package tech.sylardaemon;

import java.util.LinkedList;

public class Solution1124 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] state = new int[n];
        int[] presum = new int[n + 1];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i){
            state[i] = hours[i] > 8 ? 1 : -1;
        }
        stack.push(0);
        for (int i = 1; i <= n; ++i){
            presum[i] = presum[i - 1] + state[i - 1];
            if (presum[i] < stack.peek()){
                stack.push(i);
            }
        }
        int maxlen = 0;
        for (int i=n+1;i>=0;i--) {

            while(!stack.isEmpty() && presum[i] > presum[stack.peek()]) {

                maxlen = Math.max(maxlen, i - stack.pop());
            }
        }
        return maxlen;
    }
}
