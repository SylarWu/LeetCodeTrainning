package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        List<Integer>[] map = buildMap(edges, patience.length);
        int[] shortPath = bfsFindShortPath(map);
        int maxClearTime = 0;
        for (int i = 1; i < shortPath.length; ++i){
            int receiveTime = shortPath[i] * 2;
            int clearTime = patience[i] > receiveTime ? receiveTime : (receiveTime - 1)/patience[i]*patience[i] + receiveTime;
            maxClearTime = Math.max(maxClearTime, clearTime);
        }
        return maxClearTime + 1;
    }

    private List<Integer>[] buildMap(int[][] edges, int n){
        List<Integer>[] result = new List[n];
        for (int i = 0; i < n; ++i){
            result[i] = new LinkedList<>();
        }
        for (int[] edge: edges){
            result[edge[0]].add(edge[1]);
            result[edge[1]].add(edge[0]);
        }
        return result;
    }

    private int[] bfsFindShortPath(List<Integer>[] map){
        int[] shortPath = new int[map.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int dist = 1;
        while (!queue.isEmpty()){
            for (int i = queue.size(); i > 0; --i){
                int cur = queue.poll();
                for (int next : map[cur]){
                    if (next != 0 && shortPath[next] == 0){
                        queue.offer(next);
                        shortPath[next] = dist;
                    }
                }
            }
            ++dist;
        }
        return shortPath;
    }
}
