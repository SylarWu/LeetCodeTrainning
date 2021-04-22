package tech.sylardaemon;

public class Solution363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sumData = transform(matrix);


        int res = Integer.MIN_VALUE;
        int temp;
        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j){

                for (int ii = 0;ii < i; ++ii){
                    for (int jj = 0; jj < j; ++jj){
                        temp = getResult(sumData,ii,jj,i,j);
                        if (temp <= k){
                            res = temp > res ? temp : res;
                        }
                    }
                }

            }
        }
        return res;
    }

    private int[][] transform(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; ++i){
            result[i][0] = matrix[i][0];
            for (int j = 1; j < n; ++j){
                result[i][j] = result[i][j - 1] + matrix[i][j];
            }
        }

        for (int j = 0; j < n; ++j){
            for (int i = 1; i < m; ++i){
                result[i][j] += result[i - 1][j];
            }
        }
        return result;
    }

    private int getResult(int[][] sumData,int row1,int col1,int row2,int col2){
        if (row1 == 0 && col1 == 0){
            return sumData[row2][col2];
        }else if (row1 == 0){
            return sumData[row2][col2] - sumData[row2][col1 - 1];
        }else if (col1 == 0){
            return sumData[row2][col2] - sumData[row1 - 1][col2];
        }
        return sumData[row2][col2] + sumData[row1 - 1][col1 - 1] - sumData[row1 - 1][col2] - sumData[row2][col1 - 1];
    }
}
