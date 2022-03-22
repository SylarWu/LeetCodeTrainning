package tech.sylardaemon;

public class Solution2038 {
    public boolean winnerOfGame(String colors) {
        int aCount = 0;
        int bCount = 0;
        for (int i = 1; i < colors.length() - 1; ++i){
            aCount += (colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A' ? 1 : 0);
            bCount += (colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B' ? 1 : 0);
        }
        return aCount > bCount;
    }
}
