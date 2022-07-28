package tech.sylardaemon.offer;

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 || pushed.length == 1){
            return true;
        }
        int n = pushed.length;
        int[] stack = new int[n];
        int stack_index = -1;
        int i = 0, j = 0;
        while (i < n && j < n){
            stack[++stack_index] = pushed[i++];
            while (stack_index != -1 && stack[stack_index] == popped[j]){
                --stack_index;
                ++j;
            }
        }
        return stack_index == -1;
    }
}
