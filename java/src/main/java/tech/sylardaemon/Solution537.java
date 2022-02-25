package tech.sylardaemon;

public class Solution537 {
    public String complexNumberMultiply(String strNum1, String strNum2) {
        int[] num1 = parseComplex(strNum1);
        int[] num2 = parseComplex(strNum2);
        int left = num1[0] * num2[0] - num1[1] * num2[1];
        int right = num1[0] * num2[1] + num1[1] * num2[0];
        StringBuilder result = new StringBuilder();
        result.append(left);
        result.append("+");
        result.append(right);
        result.append("i");
        return result.toString();
    }

    private int[] parseComplex(String num){
        int plusIndex = num.indexOf("+");
        int left = Integer.parseInt(num.substring(0, plusIndex));
        int right = Integer.parseInt(num.substring(plusIndex + 1, num.length() - 1));
        return new int[]{left, right};
    }
}
