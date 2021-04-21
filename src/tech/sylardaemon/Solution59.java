package tech.sylardaemon;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int layer = 0;
        int i ,j;
        int count = 1;
        while (count <= n * n){
            i = layer;
            j = layer;
            while (count <= n * n && j < n - layer){
                result[i][j] = count++;
                ++j;
            }
            i = layer + 1;
            j = n - layer - 1;
            while (count <= n * n && i < n - layer){
                result[i][j] = count++;
                ++i;
            }
            i = n - layer - 1;
            j = n - layer - 2;
            while (count <= n * n && j >= layer){
                result[i][j] = count++;
                --j;
            }
            i = n - layer - 2;
            j = layer;
            while (count <= n * n && i > layer){
                result[i][j] = count++;
                --i;
            }
            layer++;
        }
        return result;
    }
}
