package tech.sylardaemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution682 {
    public int calPoints(String[] ops) {
        LinkedList<Integer> counts = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < ops.length; ++i){
            if (ops[i].equals("+")){
                int tail = counts.pop();
                int temp = counts.peek() + tail;
                counts.push(tail);
                counts.push(temp);
            }else if (ops[i].equals("D")){
                counts.push(counts.peek() * 2);
            }else if (ops[i].equals("C")){
                counts.pop();
            }else {
                counts.push(Integer.parseInt(ops[i]));
            }
        }
        while (!counts.isEmpty()){
            result += counts.pop();
        }
        return result;
    }
}
