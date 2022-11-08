package tech.sylardaemon.offer;

public class Solution58 {
    public String reverseWords(String s) {
        s = s.trim();
        int left = s.length() - 1, right = left;
        StringBuilder result = new StringBuilder();
        while (left >= 0){
            while (left >= 0 && s.charAt(left) != ' '){
                --left;
            }
            result.append(' ');
            result.append(s.substring(left + 1, right + 1));
            while (left >= 0 && s.charAt(left) == ' '){
                --left;
            }
            right = left;
        }
        return result.length() == 0 ? "": result.substring(1);
    }

    public String reverseLeftWords(String s, int n) {
        char[] data = new char[s.length()];
        for (int i = 0; i < s.length(); ++i){
            data[i] = s.charAt((n + i) % data.length);
        }
        return String.valueOf(data);
    }


}
