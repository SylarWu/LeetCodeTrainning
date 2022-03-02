package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution564 {
    public String nearestPalindromic(String num) {
        long originNum = Long.parseLong(num);
        long result = -1;
        List<Long> candidates = getCandidates(num);
        for (long candidate : candidates){
            if (candidate != originNum){
                if (result == -1 ||
                        Math.abs(originNum - candidate) < Math.abs(originNum - result) ||
                        (Math.abs(originNum - candidate) == Math.abs(originNum - result) && candidate < result) ){
                    result = candidate;
                }
            }
        }
        return String.valueOf(result);
    }

    private List<Long> getCandidates(String num){
        int n = num.length();
        List<Long> candidates = new LinkedList<>();
        candidates.add((long)Math.pow(10, n) + 1);
        candidates.add((long)Math.pow(10, n - 1) - 1);
        long preSegment = Long.parseLong(num.substring(0, (n + 1) / 2));
        for (long i = preSegment - 1; i <= preSegment + 1; ++i){
            StringBuffer temp = new StringBuffer();
            StringBuffer prefix = new StringBuffer(String.valueOf(i));
            StringBuffer suffix = new StringBuffer(String.valueOf(i)).reverse();
            temp.append(prefix).append(suffix.substring(n % 2 == 1 ? 1: 0));
            candidates.add(Long.parseLong(temp.toString()));
        }
        return candidates;
    }
}
