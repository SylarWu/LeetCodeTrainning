package tech.sylardaemon.lcp;

public class Solution03 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int up = 0,right = 0;
        for (int i = 0; i < command.length(); ++i){
            if (command.charAt(i) == 'U'){
                ++up;
            }else{
                ++right;
            }
        }
        for (int i = 0;i < obstacles.length; ++i){
            if (obstacles[i][0] + obstacles[i][1] < x + y){
                int factor = obstacles[i][0] / right < obstacles[i][1] / up ?  obstacles[i][0] / right : obstacles[i][1] / up;
                int curx = right * factor;
                int cury = up * factor;

                if (isOnMyPath(command,curx,cury,obstacles[i][0],obstacles[i][1])){
                    return false;
                }
            }
        }
        int factor = x / right < y / up ? x / right : y / up;
        return isOnMyPath(command,right * factor,up * factor,x,y);
    }
    private boolean isOnMyPath(String command,int curx,int cury,int x,int y){
        for (int i = 0; i < command.length(); ++i){
            if (curx == x && cury == y){
                return true;
            }
            if (command.charAt(i) == 'R'){
                ++curx;
            }else{
                ++cury;
            }
        }
        return false;
    }
}
