package tech.sylardaemon;

public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        int latest = -1;
        for (int i = 0; i < result.length; ++i){
            if (s.charAt(i) == c && latest == -1){
                for (int j = 0; j < i; ++j){
                    result[j] = i - j;
                }
                latest = i;
            }else if (s.charAt(i) == c){
                for (int j = latest + 1; j < i; ++j){
                    result[j] = Math.min(j - latest, i - j);
                }
                latest = i;
            }
        }
        for (int i = latest + 1; i < result.length; ++i){
            result[i] = i - latest;
        }
        return result;
    }
}
