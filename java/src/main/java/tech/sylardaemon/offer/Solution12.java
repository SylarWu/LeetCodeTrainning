package tech.sylardaemon.offer;

public class Solution12 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[i].length; ++j){
                if (dfs_search(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs_search(char[][] board, int i, int j, String word, int index){
        final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (board[i][j] != word.charAt(index)){
            return false;
        }
        if (index == word.length() - 1){
            return true;
        }
        board[i][j] = 0;
        for (int[] direct: directions){
            int next_i = i + direct[0], next_j = j + direct[1];
            if (next_i < 0 || next_i >= board.length || next_j < 0 || next_j >= board[0].length || board[next_i][next_j] == 0){
                continue;
            }
            if (dfs_search(board, next_i, next_j, word, index + 1)){
                return true;
            }
        }
        board[i][j] = word.charAt(index);
        return false;
    }
}
