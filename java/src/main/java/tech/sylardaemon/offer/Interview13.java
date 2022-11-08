package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Interview13 {
    public int movingCount(int m, int n, int k) {
        final int[][] directions = new int[][]{{1, 0}, {0, 1}, {1, 1}};
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int count = 0;
        while (!queue.isEmpty()){
            int[] loc = queue.poll();
            if (loc[0] < 0 || loc[0] >= m || loc[1] < 0 || loc[1] >= n || visited[loc[0]][loc[1]] || !is_available(loc[0], loc[1], k)){
                continue;
            }
            visited[loc[0]][loc[1]] = true;
            ++count;
            for (int[] direct: directions){
                queue.offer(new int[]{loc[0] + direct[0], loc[1] + direct[1]});
            }
        }
        return count;
    }

    private boolean is_available(int x, int y, int k){
        int sum = 0;
        while (x > 0){
            sum += (x % 10);
            x /= 10;
        }
        while (y > 0){
            sum += (y % 10);
            y /= 10;
        }
        return sum <= k;
    }
}
