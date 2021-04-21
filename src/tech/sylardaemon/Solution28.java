package tech.sylardaemon;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        return bruteForce(haystack,needle);
    }

    private int bruteForce(String haystack,String needle){
        int n = haystack.length();
        int m = needle.length();
        boolean flag = true;
        for (int i = 0; i + m <= n; ++i){
            flag = true;
            for (int j = 0; j < m; ++j){
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
        return -1;
    }

    private int kmp(String haystack,String needle){
        return -1;
    }

    private int[] generateNext(String needle){
        int n = needle.length();
        int[] next = new int[n];



        return next;
    }
}
