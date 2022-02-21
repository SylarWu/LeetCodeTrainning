package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution224 {

    public int calculate(String s) {
        return evalRPN(transform(s));
    }

    private List<String> transform(String s){
        LinkedList<Character> ops = new LinkedList<>();
        LinkedList<String> res = new LinkedList<>();
        int tempInt;
        int n = s.length();
        char[] data = s.toCharArray();
        for (int i = 0; i < n; ++i){
            if (data[i] == ' '){
                continue;
            }else if (isDigit(data[i])){
                tempInt = 0;
                while (i < n && isDigit(data[i])){
                    tempInt = tempInt * 10 + (data[i] - '0');
                    ++i;
                }
                --i;
                res.add(String.valueOf(tempInt));
            }else{
                switch (data[i]){
                    case '(':
                        ops.push('(');
                        break;
                    case ')':
                        while (ops.peek() != '('){
                            res.add(String.valueOf(ops.pop()));
                        }
                        ops.pop();
                        break;
                    case '+':
                    case '-':
                        if (ops.isEmpty() || ops.peek() == '('){
                            ops.push(data[i]);
                        }else {
                            while (!ops.isEmpty() && ops.peek() != '('){
                                res.add(String.valueOf(ops.pop()));
                            }
                            ops.push(data[i]);
                        }
                        break;
                    case '*':
                    case '/':
                        if (ops.isEmpty() || ops.peek() == '('){
                            ops.push(data[i]);
                        }else if (ops.peek() == '+' || ops.peek() == '-'){
                            ops.push(data[i]);
                        }else{
                            while (ops.peek() == '*' || ops.peek() == '/'){
                                res.add(String.valueOf(ops.pop()));
                            }
                            ops.push(data[i]);
                        }
                        break;
                    default:
                }
            }
        }
        while (!ops.isEmpty()){
            res.add(String.valueOf(ops.pop()));
        }
        return res;
    }
    private int evalRPN(List<String> tokens) {
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



    private boolean isDigit(char c){
        return c <= '9' && c >= '0';
    }

    private int getWeight(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
                return 3;

            default:
                return 0;
        }
    }

}
