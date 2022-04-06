package tech.sylardaemon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1){
            result.add(0);
            return result;
        }
        int[] degree = new int[n];
        List<Integer>[] nextTable = new List[n];
        for (int i = 0; i < n; ++i){
            nextTable[i] = new ArrayList<>();
        }
        for (int[] edge: edges){
            ++degree[edge[0]];
            ++degree[edge[1]];
            nextTable[edge[0]].add(edge[1]);
            nextTable[edge[1]].add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i){
            if (degree[i] == 1){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            result = new ArrayList<>();
            for (int i = queue.size(); i > 0; --i){
                int node = queue.poll();
                result.add(node);
                for (int next: nextTable[node]){
                    --degree[next];
                    if (degree[next] == 1){
                        queue.offer(next);
                    }
                }
            }
        }
        return result;
    }
}
