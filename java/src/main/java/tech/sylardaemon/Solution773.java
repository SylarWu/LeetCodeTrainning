package tech.sylardaemon;

import java.util.*;

public class Solution773 {

    private static final int ROW_LEN = 2;
    private static final int COL_LEN = 3;
    private static final int[][] DIRECT = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int[][] TARGET = {{1, 2, 3}, {4, 5, 0}};

    class Board {
        int[][] core;
        int zeroi;
        int zeroj;

        Board(int[][] core, int zeroi, int zeroj) {
            this.core = new int[ROW_LEN][COL_LEN];
            for (int i = 0; i < ROW_LEN; ++i) {
                for (int j = 0; j < COL_LEN; ++j) {
                    this.core[i][j] = core[i][j];
                }
            }
            this.zeroi = zeroi;
            this.zeroj = zeroj;
        }


        @Override
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < ROW_LEN; ++i) {
                for (int j = 0; j < COL_LEN; ++j) {
                    buffer.append(this.core[i][j]);
                }
            }
            return buffer.toString();
        }
    }

    public int slidingPuzzle(int[][] board) {
        int zeroi = 0, zeroj = 0;
        for (int i = 0; i < ROW_LEN; ++i) {
            for (int j = 0; j < COL_LEN; ++j) {
                if (board[i][j] == 0) {
                    zeroi = i;
                    zeroj = j;
                }
            }
        }

        return twoWayBFS(new Board(board, zeroi, zeroj));
    }

    private int twoWayBFS(Board start) {
        Board cur = start;
        Board end = new Board(TARGET, ROW_LEN - 1, COL_LEN - 1);
        Queue<Board> topLane = new LinkedList<>(), botLane = new LinkedList<>();
        Set<String> topMemory = new HashSet<>(), botMemory = new HashSet<>();
        int topLen, botLen;
        int topStep = 0, botStep = 0;

        topLane.offer(cur);
        topMemory.add(cur.toString());
        botLane.offer(end);
        botMemory.add(end.toString());

        while (!topLane.isEmpty() && !botLane.isEmpty()) {
            topLen = topLane.size();
            botLen = botLane.size();
            if (topLen <= botLen) {
                if (canMeetInBetween(topLane, topLen, topMemory, botMemory)) {
                    return topStep + botStep;
                }
                ++topStep;
            } else {
                if (canMeetInBetween(botLane, botLen, botMemory, topMemory)) {
                    return topStep + botStep;
                }
                ++botStep;
            }
        }
        return -1;
    }

    private boolean canMeetInBetween(Queue<Board> lane, int len, Set<String> memory, Set<String> other) {
        Board cur;
        for (int i = 0; i < len; ++i) {
            cur = lane.poll();
            if (other.contains(cur.toString())) {
                return true;
            }
            for (Board next : nextState(cur)) {
                if (!memory.contains(next.toString())) {
                    lane.offer(next);
                    memory.add(next.toString());
                }
            }
        }
        return false;
    }

    private int oneWayBFS(Board start) {
        Board cur = start;

        HashSet<String> memory = new HashSet<>();
        Queue<Board> lane = new LinkedList<>();

        lane.offer(cur);
        memory.add(cur.toString());
        int len;
        int step = 0;

        while (!lane.isEmpty()) {
            len = lane.size();
            for (int i = 0; i < len; ++i) {
                cur = lane.poll();
                if (isSame(cur.core, TARGET)) {
                    return step;
                }
                for (Board next : nextState(cur)) {
                    if (!memory.contains(next.toString())) {
                        lane.offer(next);
                        memory.add(next.toString());
                    }
                }
            }
            ++step;
        }
        return -1;
    }

    private boolean isSame(int[][] board, int[][] template) {
        for (int i = 0; i < template.length; ++i) {
            for (int j = 0; j < template[i].length; ++j) {
                if (board[i][j] != template[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<Board> nextState(Board cur) {
        List<Board> result = new LinkedList<>();
        Board next;
        int newi, newj;
        for (int i = 0; i < 4; ++i) {
            newi = cur.zeroi + DIRECT[i][0];
            newj = cur.zeroj + DIRECT[i][1];
            if (newi >= 0 && newi < ROW_LEN && newj >= 0 && newj < COL_LEN) {
                next = new Board(cur.core, newi, newj);
                next.core[cur.zeroi][cur.zeroj] = next.core[newi][newj];
                next.core[newi][newj] = 0;
                result.add(next);
            }
        }
        return result;
    }
}
