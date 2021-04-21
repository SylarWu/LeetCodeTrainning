package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        int[][] mark = new int[n][2];
        for (int i = 0; i < n; ++i){
            mark[i][0] = -1;
            mark[i][1] = -1;
        }
        int[][] board = new int[n][n];
        for (int i = 0; i < n; ++i){
            board[0][i] = 1;
            mark[0][0] = 0;
            mark[0][1] = i;
            dfs(board,1,mark,res);
            board[0][i] = 0;
        }
        return res;
    }

    private void dfs(int[][] board,int row,int[][] mark,List<List<String>> res){
        if (row >= board.length){
            res.add(transform(board));
            return;
        }
        boolean canGoDeep;
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
                dfs(board,row + 1,mark,res);
                board[row][i] = 0;
                mark[row][0] = -1;
                mark[row][1] = -1;
            }
        }
        return;
    }

    private boolean isInAttackRange(int ai,int aj,int bi,int bj){
        return ai == bi || aj == bj || abs(ai - bi) == abs(aj - bj);
    }

    private int abs(int x){
        return x > 0 ? x : -x;
    }

    private List<String> transform(int[][] board){
        int n = board.length;
        List<String> res = new LinkedList<>();
        StringBuilder temp;
        for (int i = 0; i < n; ++i){
            temp = new StringBuilder();
            for (int j = 0; j < n; ++j){
                temp.append(board[i][j] == 1 ? 'Q' : '.');
            }
            res.add(temp.toString());
        }
        return res;
    }
}
