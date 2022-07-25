package tech.sylardaemon.offer;

public class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0){
            if (target == matrix[i][j]){
                return true;
            }else if (target > matrix[i][j]){
                ++i;
            }else {
                --j;
            }
        }
        return false;
    }
}
