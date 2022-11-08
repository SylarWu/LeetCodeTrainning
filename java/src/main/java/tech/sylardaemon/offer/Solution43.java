package tech.sylardaemon.offer;

public class Solution43 {
    public int countDigitOne(int n) {
        int digit = 1, result = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0){
            if(cur == 0){
                result += high * digit;
            }else if (cur == 1){
                result += high * digit + low + 1;
            }else {
                result += (high + 1) * digit;
            }
            low = low + cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return result;
    }
}
