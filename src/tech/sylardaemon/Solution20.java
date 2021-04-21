package tech.sylardaemon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character,Character> dict = new HashMap<>();
        dict.put(')','(');
        dict.put(']','[');
        dict.put('}','{');
        int len = s.length();
        char temp;
        for (int i = 0; i < len; ++i){
            switch (s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()){
                        return false;
                    }
                    temp = stack.pop();
                    if (temp != dict.get(s.charAt(i))){
                        return false;
                    }
                    break;

                default:return false;
            }
        }
        return stack.isEmpty();
    }
}
