package tech.sylardaemon.offer;

public class Solution67 {
    public int strToInt(String str) {
        int begin = 0;
        while (begin < str.length() && str.charAt(begin) == ' '){
            ++begin;
        }
        if (begin >= str.length() || (!is_digit(str.charAt(begin)) &&
                str.charAt(begin) != '-' && str.charAt(begin) != '+')){
            return 0;
        }
        int sign = str.charAt(begin) == '-' ? -1: 1;
        if (str.charAt(begin) == '-' || str.charAt(begin) == '+'){
            ++begin;
        }
        int end = begin;
        while (end < str.length() && is_digit(str.charAt(end))){
            ++end;
        }
        str = str.substring(begin, end);
        int result = 0;
        for (int i = 0; i < str.length(); ++i){
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0' > Integer.MAX_VALUE % 10))){
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (str.charAt(i) - '0' > -(Integer.MIN_VALUE % 10)))){
                return Integer.MIN_VALUE;
            }
            result = result * 10 + sign * (str.charAt(i) - '0');
        }
        return result;
    }

    private boolean is_digit(char c){
        return '0' <= c && c <= '9';
    }
}
