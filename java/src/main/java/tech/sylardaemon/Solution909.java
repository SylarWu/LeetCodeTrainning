package tech.sylardaemon;

import java.util.*;

public class Solution909 {
    private static final int JUMP_LEN = 6;

    private int[] decode(int x, int N) {
        int away = (x - 1) / N;
        int offset = (x - 1) % N;
        return new int[]{N - 1 - away, (away % 2 == 0) ? offset : (N - 1 - offset)};
    }

    private int encode(int[] loc, int N) {
        int away = N - 1 - loc[0];
        return away * N + ((away % 2 == 0) ? loc[1] : (N - 1 - loc[1])) + 1;
    }


    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int end = N * N;
        Set<Integer> memory = new HashSet<>();
        Queue<Integer> lane = new LinkedList<>();
        lane.offer(1);
        memory.add(1);

        int step = 0;
        int len;
        Integer cur;
        int[] loc;

        while (!lane.isEmpty()) {
            len = lane.size();
            for (int i = 0; i < len; ++i) {
                cur = lane.poll();
                if (cur == end) {
                    return step;
                }
                for (int j = 1; j <= JUMP_LEN; ++j) {
                    if (cur + j <= end && !memory.contains(cur + j)) {
                        loc = decode(cur + j, N);
                        if (board[loc[0]][loc[1]] != -1) {
                            lane.offer(board[loc[0]][loc[1]]);
                        } else {
                            lane.offer(cur + j);
                        }
                        memory.add(cur + j);
                    }
                }
            }
            ++step;
        }
        return -1;
    }

}
