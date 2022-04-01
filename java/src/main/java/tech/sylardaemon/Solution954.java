package tech.sylardaemon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution954 {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        while (left < arr.length && arr[left] < 0){
            ++left;
        }
        int right = left--;
        while (right < arr.length && arr[right] == 0){
            ++right;
        }
        if ((right - left - 1) % 2 != 0){
            return false;
        }
        Map<Integer, Integer> memory = new HashMap<>();
        for (int i = left; i >= 0; --i){
            if (!memory.containsKey(arr[i])){
                memory.put(arr[i] * 2, memory.getOrDefault(arr[i] * 2, 0) + 1);
            }else{
                int count = memory.get(arr[i]) - 1;
                if (count == 0){
                    memory.remove(arr[i]);
                }else{
                    memory.put(arr[i], count);
                }
            }
        }
        for (int i = right; i < arr.length; ++i){
            if (!memory.containsKey(arr[i])){
                memory.put(arr[i] * 2, memory.getOrDefault(arr[i] * 2, 0) + 1);
            }else{
                int count = memory.get(arr[i]) - 1;
                if (count == 0){
                    memory.remove(arr[i]);
                }else{
                    memory.put(arr[i], count);
                }
            }
        }
        return memory.isEmpty();
    }
}
