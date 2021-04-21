package tech.sylardaemon;

import java.util.HashMap;
import java.util.Map;

public class Solution957 {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<Integer,int[]> map = new HashMap<>();
        map.put(0,next(cells));
        int i = 1;
        int[] next = next(map.get(0));
        while (!isSame(map.get(0),next)){
            map.put(i,next);
            next = next(next);
            ++i;
        }
        for (int j = 0; j < map.size(); ++j){
            int[] out = map.get(j);
            System.out.print(String.valueOf(j) + ":");
            for (int x : out){
                System.out.print(String.valueOf(x) + ",");
            }
            System.out.println();
        }
        return map.get((n - 1) % map.size());
    }
    private boolean isSame(int[] state1,int[] state2){
        for (int i = 0; i <state1.length ; ++i){
            if (state1[i] != state2[i]){
                return false;
            }
        }
        return true;
    }
    private int[] next(int[] cells){
        int[] next = new int[cells.length];
        for (int i = 1; i < cells.length - 1; ++i){
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return next;
    }
}
