package tech.sylardaemon;

import java.util.LinkedList;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; ++i){
            for (int j = 0; j < grid[i].length; ++j){
                if (grid[i][j] == 1){
                    maxArea = Math.max(stackPaintColor(grid, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfsPaintCorlor(int[][] grid, int x, int y){
        final int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 0){
            return 0;
        }
        grid[x][y] = 0;
        int area = 1;
        for (int[] dir : direction){
            area += dfsPaintCorlor(grid, x + dir[0], y + dir[1]);
        }
        return area;
    }

    private int stackPaintColor(int[][] grid, int x, int y){
        final int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        LinkedList<int[]> stack = new LinkedList<>();
        stack.push(new int[]{x, y});
        int area = 0;
        while (!stack.isEmpty()){
            int[] cur = stack.pop();
            if (cur[0] < 0 || cur[0] >= grid.length || cur[1] < 0 || cur[1] >= grid[cur[0]].length || grid[cur[0]][cur[1]] == 0){
                continue;
            }
            ++area;
            grid[cur[0]][cur[1]] = 0;
            for (int[] dir: direction){
                stack.push(new int[]{cur[0] + dir[0], cur[1] + dir[1]});
            }
        }
        return area;
    }
}
