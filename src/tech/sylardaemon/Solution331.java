package tech.sylardaemon;

import java.util.LinkedList;

public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        int top = 0;
        for (int i = 0 ; i < nodes.length ; ++i){
            if (stack.isEmpty()){
                return false;
            }
            top = stack.pop() - 1;
            if (top > 0){
                stack.push(top);
            }
            if (!nodes[i].equals("#")){
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}
