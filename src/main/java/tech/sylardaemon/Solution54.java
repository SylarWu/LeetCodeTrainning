package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int max_layer = m > n ? (n - 1) / 2 : (m - 1) / 2;
        int i,j;
        for (int layer = 0 ; layer <= max_layer ; ++layer){
            i = layer;
            j = layer;
            while (result.size() < m * n && j < n - layer){
                result.add(matrix[i][j]);
                ++j;
            }
            i = layer + 1;
            j = n - layer - 1;
            while (result.size() < m * n && i < m - layer){
                result.add(matrix[i][j]);
                ++i;
            }
            i = m - layer - 1;
            j = n - layer - 2;
            while(result.size() < m * n && j >= layer){
                result.add(matrix[i][j]);
                --j;
            }
            i = m - layer - 2;
            j = layer;
            while(result.size() < m * n && i > layer){
                result.add(matrix[i][j]);
                --i;
            }
        }
        return result;
    }
}
