package tech.sylardaemon;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || ((x % 10) == 0 && x != 0)){
            return false;
        }
        int y = 0;
        while (x > y){
            y = y * 10 + (x % 10);
            x = x / 10;
        }
        return x == y || x == (y / 10);
    }

    private boolean firstInMyHead(int x){
        String temp = String.valueOf(x);
        int n = temp.length();
        for (int i = 0; i < n ; ++i){
            if (temp.charAt(i) != temp.charAt(n - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
