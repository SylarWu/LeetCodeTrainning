package tech.sylardaemon;

public class Solution91 {
    public int numDecodings(String s) {
        if (s == null || s.equals("") || s.startsWith("0")){
            return 0;
        }
        int n = s.length();
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 1; i <= n; ++i){
            c = 0;
            if (s.charAt(i - 1) != '0'){
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2)-'0')*10 + (s.charAt(i - 1)-'0') <= 26){
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
