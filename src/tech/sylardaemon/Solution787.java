package tech.sylardaemon;

public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        return DijkstraMutation(n, flights, src, dst, K);
    }

    private int DijkstraMutation(int n, int[][] flights, int src, int dst, int K){
        int[][] matrix = new int[n][n];
        int maxCost = 0;
        int[] path = new int[n];
        int[] cost = new int[n];
        int[] limit = new int[n];
        for (int i = 0; i < flights.length; ++i){
            matrix[flights[i][0]][flights[i][1]] = flights[i][2];
            maxCost = flights[i][2] > maxCost ? flights[i][2] : maxCost;
        }
        int miniIndex = 0;
        for (int i = 0; i < n ; ++i){
            if (i != src){
                if (matrix[src][i] != 0){
                    path[i] = src;
                    cost[i] = matrix[src][i];

                }else{
                    path[i] = -1;
                    cost[i] = maxCost;
                }
            }
        }
        return 0;

    }
}
