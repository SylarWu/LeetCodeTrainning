package tech.sylardaemon;

public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        int begin = n & 0x1;
        while (n != 0){
            if ((n & 0x1) == begin && ((n >> 1) & 0x1) != begin){
                n >>= 2;
            }else{
                return false;
            }
        }
        return true;
    }
}
