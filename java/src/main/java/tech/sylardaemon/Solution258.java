package tech.sylardaemon;

public class Solution258 {
    public int addDigits(int num) {
        return num == 0 ? 0 : ( num % 9 == 0 ? 9 : (num % 9));
    }

    private int loopMethod(int num){
        while (num >= 10){
            int result = 0;
            while (num != 0){
                result += (num % 10);
                num /= 10;
            }
            num = result;
        }
        return num;
    }
}
