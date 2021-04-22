package tech.sylardaemon;

public class Solution304 {
    class NumMatrix {

        private int[][] sumData;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0){
                return;
            }

            int row_len = matrix.length;
            int col_len = matrix[0].length;

            this.sumData = new int[row_len][col_len];

            for (int i = 0; i < row_len; ++i){
                for (int j = 0; j < col_len; ++j){
                    if (j == 0){
                        this.sumData[i][j] = matrix[i][j];
                    }else{
                        this.sumData[i][j] = this.sumData[i][j - 1] + matrix[i][j];
                    }
                }
            }

            for (int j = 0; j < col_len; ++j){
                for (int i = 1; i < row_len; ++i){
                    this.sumData[i][j] += this.sumData[i - 1][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 == 0 && col1 == 0){
                return this.sumData[row2][col2];
            }else if (row1 == 0){
                return this.sumData[row2][col2] - this.sumData[row2][col1 - 1];
            }else if (col1 == 0){
                return this.sumData[row2][col2] - this.sumData[row1 - 1][col2];
            }
            return this.sumData[row2][col2] + this.sumData[row1 - 1][col1 - 1] - this.sumData[row1 - 1][col2] - this.sumData[row2][col1 - 1];
        }
    }
}
