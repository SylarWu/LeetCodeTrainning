package tech.sylardaemon;

import java.util.LinkedList;

public class Solution504 {
    public String convertToBase7(int num) {
        if (num == 0){
            return "0";
        }
        StringBuffer result = new StringBuffer();
        boolean negative = num < 0;
        num = Math.abs(num);
        while (num != 0){
            result.append(num % 7);
            num /= 7;
        }
        if (negative){
            result.append("-");
        }
        return result.reverse().toString();
    }
}
