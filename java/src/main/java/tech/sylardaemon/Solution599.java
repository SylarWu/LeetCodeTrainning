package tech.sylardaemon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> mapping = new HashMap<>();
        List<String> result = new LinkedList<>();
        for (int i = 0; i < list1.length; ++i){
            mapping.put(list1[i], i);
        }
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; ++i){
            if (mapping.containsKey(list2[i])){
                int j = mapping.get(list2[i]);
                if (i + j < indexSum){
                    indexSum = i + j;
                    result.clear();
                    result.add(list2[i]);
                }else if (i + j == indexSum){
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
