package tech.sylardaemon;

public class Solution1706 {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        for (int i = 0; i < n; ++i){
            result[i] = i;
        }
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (result[j] == -1){
                    continue;
                }
                if ((result[j] == 0 && grid[i][0] == -1) || (result[j] == n - 1 && grid[i][n - 1] == 1) ||
                        (grid[i][result[j]] == 1 && grid[i][result[j] + 1] == -1) ||
                        (grid[i][result[j]] == -1 && grid[i][result[j] - 1] == 1)){
                    result[j] = -1;
                }else{
                    result[j] += grid[i][result[j]];
                }
            }
        }
        return result;
    }
}
