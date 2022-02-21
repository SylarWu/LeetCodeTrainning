package tech.sylardaemon;

public class Solution8 {
    public int myAtoi(String s) {
        char[] data = s.toCharArray();
        for (int i = 0; i < data.length; ++i){
            if (data[i] == ' '){
                continue;
            }else if (data[i] == '-'){
                return readDigit(data, i + 1, true);
            }else if (data[i] == '+'){
                return readDigit(data, i + 1, false);
            }else if (isDigit(data[i])){
                return readDigit(data, i, false);
            }else{
                break;
            }
        }
        return 0;
    }

    private int readDigit(char[] data,int index, boolean negtive){
        if (index >= data.length || !isDigit(data[index])){
            return 0;
        }
        int res = 0;
        int i = index;
        int sign = negtive ? -1 : 1;
        while (i < data.length && isDigit(data[i])){
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (data[i] - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (data[i] - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (data[i] - '0');
            ++i;
        }
        return res;
    }


    private boolean isDigit(char c){
        return c <= '9' && c >= '0';
    }
}
