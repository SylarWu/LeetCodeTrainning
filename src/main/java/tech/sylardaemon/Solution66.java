package tech.sylardaemon;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        ++digits[n - 1];
        for (int i = n - 2; i >= 0; --i){
            if (digits[i + 1] >= 10){
                digits[i + 1] -= 10;
                digits[i] += 1;
            }else{
                break;
            }
        }
        if (digits[0] >= 10){
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }else{
            return digits;
        }
    }
}
