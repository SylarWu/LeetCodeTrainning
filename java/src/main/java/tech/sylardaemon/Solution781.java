package tech.sylardaemon;

import java.util.HashMap;
import java.util.Map;

public class Solution781 {
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> result = new HashMap<>();
        int res = 0;
        for (int i = 0; i < answers.length; ++i){
            if (!result.containsKey(answers[i])){
                result.put(answers[i],1);
            }else{
                result.put(answers[i],result.get(answers[i]) + 1);
            }
        }
        int key,value;
        for (Map.Entry<Integer,Integer> entry : result.entrySet()){
            key = entry.getKey();
            value = entry.getValue();
            res += value / (key + 1) * (key + 1) + ((value % (key + 1)) == 0 ? 0 : (key + 1));
        }
        return res;
    }
}
