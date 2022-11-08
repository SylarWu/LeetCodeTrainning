package tech.sylardaemon.offer;

public class Solution46 {
    public int translateNum(int num) {
        String str_num = String.valueOf(num);
        int a = 1, b = 1, c = 1;
        for (int i = 1; i < str_num.length(); ++i){
            c = b + (isInRange(str_num.charAt(i - 1), str_num.charAt(i)) ? a: 0);
            a = b;
            b = c;
        }
        return c;
    }

    private boolean isInRange(char a, char b){
        return (a == '1' && '0' <= b && b <= '9') || (a == '2' && '0' <= b && b <= '5');
    }
}
