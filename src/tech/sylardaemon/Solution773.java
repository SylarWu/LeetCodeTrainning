package tech.sylardaemon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution773 {

    class Board{
        int[][] core;
        int zeroi;
        int zeroj;
        int count;

        Board(int[][] core,int zeroi,int zeroj,int count){
            this.core = new int[2][3];
            for (int i = 0;i < 2;++i){
                for (int j = 0;j < 3;++j){
                    this.core[i][j] = core[i][j];
                }
            }
            this.zeroi = zeroi;
            this.zeroj = zeroj;
            this.count = count;
        }


        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 2; ++i){
                for (int j = 0; j < 3; ++j){
                    builder.append(this.core[i][j]);
                }
            }
            return builder.toString();
        }
    }

    private int[][] template = {{1,2,3},{4,5,0}};

    public int slidingPuzzle(int[][] board) {
        int[][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
        HashSet<String> hashSet = new HashSet<>();
        Queue<Board> q = new LinkedList();
        int zeroi = 0,zeroj = 0;
        for (int i = 0; i < board.length ; ++i){
            for (int j = 0; j < board[i].length ; ++j){
                if (board[i][j] == 0){
                    zeroi = i;
                    zeroj = j;
                }
            }
        }
        q.offer(new Board(board,zeroi,zeroj,0));
        Board b;
        while (!q.isEmpty()){
            b = q.poll();
            hashSet.add(b.toString());
            for (int i = 0; i < 4; ++i){
                int newi = b.zeroi + direc[i][0];
                int newj = b.zeroj + direc[i][1];
                if (newi >= 0 && newi < 2 && newj >= 0 && newj < 3){
                    Board temp = new Board(b.core,newi,newj,b.count + 1);
                    temp.core[b.zeroi][b.zeroj] = temp.core[newi][newj];
                    temp.core[newi][newj] = 0;
                    if (hashSet.contains(temp.toString())){
                        continue;
                    }
                    q.offer(temp);
                }
            }
            if (isSame(b.core,this.template)){
                return b.count;
            }
        }
        return -1;
    }

    private boolean isSame(int[][] board,int[][] template){
        for (int i = 0; i < template.length; ++i){
            for (int j = 0; j < template[i].length ; ++j){
                if (board[i][j] != template[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
