package tech.sylardaemon;

import java.util.HashMap;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        for (int i = 0; i < n ; ++i){
            if (map.containsKey(s.charAt(i))){
                left = (left > map.get(s.charAt(i))) ? left : (map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            result = (i - left + 1) > result ? (i - left + 1) : result;
        }
        return result;
    }
}
