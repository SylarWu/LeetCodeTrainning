package tech.sylardaemon;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution388 {

    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        int result = 0;
        for(String path : paths){
            int depth = depth(path);
            while (stack.size() > depth + 1){
                stack.pop();
            }
            int length = stack.peek() + path.length() - depth;
            if (path.contains(".")){
                result = Math.max(result, length);
            }else{
                stack.push(length + 1);
            }
        }
        return result;
    }
    public int depth(String path){
        int i = 0;
        while (i < path.length() && path.charAt(i) == '\t'){
            ++i;
        }
        return i;
    }


}
