package tech.sylardaemon.offer;

public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int n = matrix.length, m = matrix[0].length;
        int[] result = new int[n * m];
        int layer = 0;
        int i = 0, j = 0, k = 0;
        while (k < n * m){
            i = layer;
            j = layer;
            while (k < n * m && j <= m - 1 - layer){
                result[k++] = matrix[i][j++];
            }
            i = layer + 1;
            j = m - 1 - layer;
            while (k < n * m && i <= n - 1 - layer){
                result[k++] = matrix[i++][j];
            }
            i = n - 1 - layer;
            j = m - 1 - layer - 1;
            while (k < n * m && j >= layer){
                result[k++] = matrix[i][j--];
            }
            i = n - 1 - layer - 1;
            j = layer;
            while (k < n * m && i >= layer + 1){
                result[k++] = matrix[i--][j];
            }
            ++layer;
        }
        return result;
    }
}
