package tech.sylardaemon;

public class Solution1728 {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int row_len = grid.length;
        int col_len = grid[0].length();
        int[][] matrix = new int[row_len][col_len];
        int[][][] memory = new int[100][64][64];
        int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
        int m_i = 0, m_j = 0;
        int c_i = 0, c_j = 0;
        int mouse_move_count = 0;
        /*初试化*/
        for (int i = 0;i < row_len; ++i){
            for (int j = 0; j < col_len; ++j){
                switch (grid[i].charAt(j)){
                    case 'F':
                        matrix[i][j] = 1;
                        break;
                    case 'C':
                        c_i = i;
                        c_j = j;
                        break;
                    case 'M':
                        m_i = i;
                        m_j = j;
                        break;
                    case '#':
                        matrix[i][j] = -1;
                        break;
                    default:
                        matrix[i][j] = 0;
                        break;
                }
                System.out.print(matrix[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
        return dp(matrix,memory,direction,true,m_i,m_j,c_i,c_j,mouse_move_count,catJump,mouseJump);
    }

    private boolean dp(int[][] matrix,int[][][] memory,int[][] direction,boolean mouse_turn,int m_i, int m_j, int c_i, int c_j,int mouse_move_count,int catJump,int mouseJump){
        if (mouse_move_count >= 100){
            return false;
        }
        if (matrix[m_i][m_j] == 1){
            memory[mouse_move_count][m_i * 8 + m_j][c_i * 8 + c_j] = 1;
            return true;
        }
        if (matrix[c_i][c_j] == 1 || (c_i == m_i && c_j == m_j)){
            memory[mouse_move_count][m_i * 8 + m_j][c_i * 8 + c_j] = 2;
            return false;
        }
        if (memory[mouse_move_count][m_i * 8 + m_j][c_i * 8 + c_j] != 0){
            return memory[mouse_move_count][m_i * 8 + m_j][c_i * 8 + c_j] == 1;
        }
        if (mouse_turn){
            for (int direc = 0;direc < 4; ++direc){
                for (int i = 0; i <= mouseJump; ++i){
                    int new_i = m_i + i * direction[direc][0];
                    int new_j = m_j + i * direction[direc][1];
                    if (!canItMove(matrix,new_i,new_j)){
                        break;
                    }
                    if (new_i == c_i && new_j == c_j){
                        continue;
                    }
                    if (dp(matrix,memory,direction,false,new_i,new_j,c_i,c_j,mouse_move_count + 1,catJump,mouseJump)){
                        memory[mouse_move_count][new_i * 8 + new_j][c_i * 8 + c_j] = 1;
                        return true;
                    }
                }
            }
            memory[mouse_move_count][m_i * 8 + m_j][c_i * 8 + c_j] = 2;
            return false;
        }else{
            for (int direc = 0;direc < 4; ++direc){
                for (int i = 0; i <= catJump; ++i){
                    int new_i = c_i + i * direction[direc][0];
                    int new_j = c_j + i * direction[direc][1];
                    if (!canItMove(matrix,new_i,new_j)){
                        break;
                    }
                    if (!dp(matrix,memory,direction,true,m_i,m_j,new_i,new_j,mouse_move_count,catJump,mouseJump)){
                        memory[mouse_move_count][m_i * 8 + m_j][new_i * 8 + new_j] = 2;
                        return false;
                    }
                }
            }
            memory[mouse_move_count][m_i * 8 + m_j][c_i * 8 + c_j] = 1;
            return true;
        }
    }
    private boolean canItMove(int[][] matrix,int i,int j){
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length ){
            return false;
        }
        return matrix[i][j] != -1;
    }

}
