package tech.sylardaemon.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        char[] data = s.toCharArray();
        Map<Character, Integer> memory = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < data.length){
            if (memory.containsKey(data[right])){
                int index = memory.get(data[right]);
                left = index >= left ? (index + 1): left;
            }
            memory.put(data[right], right);
            result = Math.max(result, right - left + 1);
            ++right;
        }
        return result;
    }
}
