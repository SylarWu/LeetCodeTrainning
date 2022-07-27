package tech.sylardaemon.offer;

public class Solution20 {
    public boolean isNumber(String s) {
        char[] data = s.toCharArray();
        int e_index = -1;
        int dot_index = -1;
        int left = 0, right = data.length - 1;
        while (left < data.length && data[left] == ' '){
            ++left;
        }
        while (right >= 0 && data[right] == ' '){
            --right;
        }
        if (left >= data.length || right < 0){
            return false;
        }
        for (int i = left; i <= right; ++i){
            if (data[i] == 'e' || data[i] == 'E'){
                if (e_index != -1){
                    return false;
                }
                e_index = i;
            }
            if (data[i] == '.'){
                if (dot_index != -1){
                    return false;
                }
                dot_index = i;
            }
        }
        if (e_index == -1){
            return isDecimal(data, left, right, dot_index) || isInteger(data, left, right);
        }else{
            return (isDecimal(data, left, e_index - 1, dot_index) || isInteger(data, left, e_index - 1)) &&
                    isInteger(data, e_index + 1, right);
        }
    }

    private boolean isDecimal(char[] data, int left, int right, int dot_index){
        if (left <= right && (data[left] == '+' || data[left] == '-')){
            ++left;
        }
        if (left > right){
            return false;
        }
        if (dot_index < left || dot_index > right){
            return false;
        }else if (left == dot_index && right == dot_index){
            return false;
        }else{
            for (int i = left; i <= right; ++i){
                if (data[i] != '.' && !isDigit(data[i])){
                    return false;
                }
            }
            return true;
        }
    }

    private boolean isInteger(char[] data, int left, int right){
        if (left <= right && (data[left] == '+' || data[left] == '-')){
            ++left;
        }
        if (left > right){
            return false;
        }
        for (int i = left; i <= right; ++i){
            if (!isDigit(data[i])){
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}
