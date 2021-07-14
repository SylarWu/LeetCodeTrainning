package tech.sylardaemon;

import java.util.Arrays;

public class Solution274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hindex = 0;
        int i = citations.length;
        while (i >= 0 && citations[i] > hindex){
            ++hindex;
            --i;
        }
        return hindex;
    }
}
