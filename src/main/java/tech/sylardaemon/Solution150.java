package tech.sylardaemon;

import java.util.LinkedList;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        int b;
        int a;
        for (String x : tokens){
            switch (x){
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(x));
            }
        }
        return stack.pop();
    }
}
