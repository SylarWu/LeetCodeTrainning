package tech.sylardaemon;

import java.util.LinkedList;

public class Solution227 {
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        char preChar = '+';

        char[] data = s.toCharArray();

        int tempInt = 0;
        for (int i = 0; i < data.length; ++i){
            if (data[i] >= '0' && data[i] <= '9'){
                tempInt = tempInt * 10 + (data[i] - '0');
            }
            if (data[i] == '+' || data[i] == '-' || data[i] == '*' || data[i] == '/' || i == data.length - 1){
                switch(preChar){
                    case '+':
                        stack.push(tempInt);
                        break;
                    case '-':
                        stack.push(-tempInt);
                        break;
                    case '*':
                        stack.push(stack.pop() * tempInt);
                        break;
                    case '/':
                        stack.push(stack.pop() / tempInt);
                        break;
                        default:
                }
                preChar = data[i];
                tempInt = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
