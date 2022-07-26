package tech.sylardaemon.offer;

import java.util.LinkedList;

public class Solution13 {
    public int movingCount(int m, int n, int k) {
        return bfs(m, n, k);
    }

    private int bfs(int m, int n, int k){
        final int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.addLast(new int[]{0, 0});
        int movingCount = 0;
        while (!queue.isEmpty()){
            int[] cur = queue.removeFirst();
            if (!visited[cur[0]][cur[1]]){
                visited[cur[0]][cur[1]] = true;
                if (check_check(cur[0], cur[1], k)){
                    ++movingCount;
                    for (int[] direct: directions){
                        if (cur[0] + direct[0] >= 0 && cur[0] + direct[0] < m &&
                        cur[1] + direct[1] >= 0 && cur[1] + direct[1] < n)
                        queue.addLast(new int[]{
                                cur[0] + direct[0], cur[1] + direct[1]
                        });
                    }
                }
            }

        }
        return movingCount;
    }

    private boolean check_check(int x, int y, int k){
        int sum = 0;
        while (x != 0){
            sum += (x % 10);
            x /= 10;
        }
        while (y != 0){
            sum += (y % 10);
            y /= 10;
        }
        return sum <= k;
    }
}
