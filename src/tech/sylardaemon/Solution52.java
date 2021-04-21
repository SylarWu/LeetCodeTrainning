package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution52 {
    public int totalNQueens(int n) {
        int[][] mark = new int[n][2];
        for (int i = 0; i < n; ++i){
            mark[i][0] = -1;
            mark[i][1] = -1;
        }
        int[][] board = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; ++i){
            board[0][i] = 1;
            mark[0][0] = 0;
            mark[0][1] = i;
            res += dfs(board,1,mark);
            board[0][i] = 0;
        }
        return res;
    }

    private int dfs(int[][] board,int row,int[][] mark){
        if (row >= board.length){
            return 1;
        }
        boolean canGoDeep;
        int res = 0;
        for (int i = 0; i < board.length; ++i){
            canGoDeep = true;
            for (int j = 0; j < row; ++j){
                if (isInAttackRange(row,i,mark[j][0],mark[j][1])){
                    canGoDeep = false;
                    break;
                }
            }
            if (canGoDeep){
                board[row][i] = 1;
                mark[row][0] = row;
                mark[row][1] = i;
                res += dfs(board,row + 1,mark);
                board[row][i] = 0;
                mark[row][0] = -1;
                mark[row][1] = -1;
            }
        }
        return res;
    }

    private boolean isInAttackRange(int ai,int aj,int bi,int bj){
        return ai == bi || aj == bj || abs(ai - bi) == abs(aj - bj);
    }

    private int abs(int x){
        return x > 0 ? x : -x;
    }
}
