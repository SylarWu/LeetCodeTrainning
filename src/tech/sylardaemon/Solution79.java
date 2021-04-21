package tech.sylardaemon;

public class Solution79 {

    private int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] data = word.toCharArray();
        int length = data.length;
        boolean[][] mark;
        if ( m * n < length){
            return false;
        }
        mark = new boolean[m][n];
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n ; ++j){
                if (board[i][j] == data[0] && beginSearch(board,mark,i,j,data,1)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean beginSearch(char[][] board,boolean[][] mark,int x,int y,char[] word,int index){
        if (index >= word.length){
            return true;
        }
        mark[x][y] = true;
        int m = board.length;
        int n = board[0].length;
        int next_x;
        int next_y;
        boolean flag = false;
        for (int i = 0; i < direction.length; ++i){
            next_x = x + direction[i][0];
            next_y = y + direction[i][1];
            if (isInTheRange(m,n,next_x,next_y) && !mark[next_x][next_y] && board[next_x][next_y] == word[index]){
                flag =  flag || beginSearch(board,mark,next_x,next_y,word,index + 1);
            }
            if (flag){
                break;
            }
        }
        mark[x][y] = false;
        return flag;
    }

    private boolean isInTheRange(int m,int n,int x,int y){
        return 0 <= x && x < m && 0 <= y && y < n;
    }

}
