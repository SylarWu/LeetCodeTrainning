package tech.sylardaemon;

public class Solution868 {
    public int binaryGap(int n) {
        int lastOne = -1;
        int maxLength = 0;
        for (int i = 0; (n >> i) != 0; ++i){
            if (((n >> i) & 0x1) == 1){
                if (lastOne != -1){
                    maxLength = Math.max(maxLength, i - lastOne);
                }
                lastOne = i;
            }
        }
        return maxLength;
    }
}
