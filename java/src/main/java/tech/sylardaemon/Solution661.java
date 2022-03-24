package tech.sylardaemon;

public class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        return brutalForceMethod(img);
    }

    private int[][] brutalForceMethod(int[][] img){
        int n = img.length, m = img[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                int value = 0, count = 0;
                for (int x = i - 1; x <= i + 1; ++x){
                    for (int y = j - 1; y <= j + 1; ++y){
                        if (x >= 0 && x < n && y >= 0 && y < m){
                            value += img[x][y];
                            ++count;
                        }
                    }
                }
                result[i][j] = value / count;
            }
        }
        return result;
    }

    private int[][] accumMethod(int[][] img){
        int n = img.length, m = img[0].length;
        int[][] accum = genAccumulation(img);
        int[][] result = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int leftx = i == 0 ? 0 : i - 1, lefty = j == 0 ? 0 : j - 1;
                int rightx = i == n - 1 ? n - 1 : i + 1, righty = j == m - 1 ? m - 1 : j + 1;
                result[i][j] = getValue(accum, leftx, lefty, rightx, righty);
                result[i][j] /= (rightx - leftx + 1)*(righty - lefty + 1);
            }
        }
        return result;
    }

    private int getValue(int[][] accum, int leftx, int lefty, int rightx, int righty){
        if (leftx == 0 && lefty == 0){
            return accum[rightx][righty];
        }else if (leftx == 0){
            return accum[rightx][righty] - accum[rightx][lefty - 1];
        }else if (lefty == 0){
            return accum[rightx][righty] - accum[leftx - 1][righty];
        }else {
            return accum[rightx][righty] - accum[rightx][lefty - 1] - accum[leftx - 1][righty] + accum[leftx - 1][lefty - 1];
        }
    }

    private int[][] genAccumulation(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        result[0][0] = img[0][0];
        for (int i = 1; i < img.length; ++i) {
            result[i][0] = result[i - 1][0] + img[i][0];
        }
        for (int i = 1; i < img[0].length; ++i) {
            result[0][i] = result[0][i - 1] + img[0][i];
        }
        for (int i = 1; i < img.length; ++i) {
            for (int j = 1; j < img[i].length; ++j) {
                result[i][j] = result[i - 1][j] + result[i][j - 1] - result[i - 1][j - 1] + img[i][j];
            }
        }
        return result;
    }
}
