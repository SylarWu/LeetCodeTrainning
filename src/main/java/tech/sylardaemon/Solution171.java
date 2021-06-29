package tech.sylardaemon;

public class Solution171 {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int factor = 1;
        int len = columnTitle.length();
        for (int i = len - 1; i >= 0; --i, factor *= 26){
            result += getNumber(columnTitle.charAt(i)) * factor;
        }
        return result;
    }

    private int getNumber(char c){
        return c - 'A' + 1;
    }
}
