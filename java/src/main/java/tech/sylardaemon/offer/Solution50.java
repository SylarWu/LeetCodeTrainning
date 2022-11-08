package tech.sylardaemon.offer;

import java.util.HashMap;
import java.util.Map;

public class Solution50 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dict = new HashMap<>();
        for (int i = 0; i < s.length(); ++i){
            dict.put(s.charAt(i), !dict.containsKey(s.charAt(i)));
        }
        for (int i = 0; i < s.length(); ++i){
            if (dict.get(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
