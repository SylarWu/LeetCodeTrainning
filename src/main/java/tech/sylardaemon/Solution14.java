package tech.sylardaemon;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length ; ++i){
            prefix = longestCommonPrefix(prefix,strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2){
        int length = str1.length() < str2.length() ? str1.length() : str2.length();
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            ++index;
        }
        return str1.substring(0,index);
    }
}
