package tech.sylardaemon;

public class Solution796 {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if (n != goal.length()){
            return false;
        }
        char[] str = new char[n * 2];
        for (int i = 0; i < n; ++i){
            str[i] = s.charAt(i);
            str[i + n] = s.charAt(i);
        }
        for (int i = 0; i < n; ++i){
            boolean isSame = true;
            for (int j = i; j < i + n; ++j){
                if (str[j] != goal.charAt(j - i)){
                    isSame = false;
                    break;
                }
            }
            if (isSame){
                return true;
            }
        }
        return false;
    }
}
