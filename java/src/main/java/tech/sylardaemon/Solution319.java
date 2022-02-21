package tech.sylardaemon;

public class Solution319 {
    public int bulbSwitch(int n) {
        if (n == 1){
            return 1;
        }
        int result = 1;
        while (true){
            if (result * result > n){
                break;
            }
            ++result;
        }
        return result - 1;
    }

}
