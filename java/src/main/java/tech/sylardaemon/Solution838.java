package tech.sylardaemon;

public class Solution838 {
    private final char R = 'R';
    private final char L = 'L';
    private final char N = '.';


    public String pushDominoes(String dominoes) {
        int n = dominoes == null ? -1 : dominoes.length();
        if (n <= 1){
            return dominoes;
        }
        char[] result = new char[n];

        int left = 0;
        while (left < n && dominoes.charAt(left) == '.'){
            result[left] = N;
            ++left;
        }
        if (left >= n){
            return String.valueOf(result);
        }
        result[left] = dominoes.charAt(left);
        if (dominoes.charAt(left) == 'L'){
            for (int i = 0; i < left; ++i){
                result[i] = L;
            }
        }
        int right = n - 1;
        while (right >= 0 && dominoes.charAt(right) == '.'){
            result[right] = N;
            --right;
        }
        if (right < 0){
            return String.valueOf(result);
        }
        result[right] = dominoes.charAt(right);
        if (dominoes.charAt(right) == 'R'){
            for (int i = n - 1; i >= right; --i){
                result[i] = R;
            }
        }
        if (left >= right){
            return String.valueOf(result);
        }

        for (int i = left + 1; i < right; ++i){
            if (dominoes.charAt(i) == 'R' || dominoes.charAt(i) == 'L'){
                result[i] = dominoes.charAt(i);
                continue;
            }
            int latestR = i - 1;
            while (latestR > left && dominoes.charAt(latestR) == '.'){
                --latestR;
            }
            int latestL = i + 1;
            while (latestL < right && dominoes.charAt(latestL) == '.'){
                ++latestL;
            }
            if ((dominoes.charAt(latestR) == 'R' && dominoes.charAt(latestL) == 'L') ){
                if (i - latestR == latestL - i){
                    result[i] = N;
                }else if (i - latestR > latestL - i){
                    result[i] = L;
                }else {
                    result[i] = R;
                }
            }else if (dominoes.charAt(latestR) == 'R'){
                result[i] = R;
            }else if (dominoes.charAt(latestL) == 'L'){
                result[i] = L;
            }else{
                result[i] = N;
            }
        }
        return String.valueOf(result);
    }
}
