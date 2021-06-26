package tech.sylardaemon;

import java.awt.desktop.QuitEvent;
import java.util.*;

public class Solution752 {

    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> locks = new HashSet<>();
        for (String lock : deadends) {
            if ("0000".equals(lock)) {
                return -1;
            }
            locks.add(lock);
        }

        return twoWayBFS(locks, target);
    }

    private int twoWayBFS(Set<String> locks, String target) {
        Queue<String> topLane = new LinkedList<>(), botLane = new LinkedList<>();
        Set<String> topMemory = new HashSet<>(), botMemory = new HashSet<>();
        int topStep = 0, botStep = 0;
        topLane.offer("0000");
        topMemory.add("0000");
        botLane.offer(target);
        botMemory.add(target);

        int topLen, botLen;

        while (!topLane.isEmpty() && !botLane.isEmpty()) {
            topLen = topLane.size();
            botLen = botLane.size();
            if (topLen <= botLen) {
                if (canMeetInBetween(topLane, topLen, topMemory, botMemory, locks)) {
                    return topStep + botStep;
                }
                ++topStep;
            } else {
                if (canMeetInBetween(botLane, botLen, botMemory, topMemory, locks)) {
                    return topStep + botStep;
                }
                ++botStep;
            }
        }
        return -1;
    }

    private boolean canMeetInBetween(Queue<String> lane, int len, Set<String> memory, Set<String> other, Set<String> locks) {
        String cur;
        for (int i = 0; i < len; ++i) {
            cur = lane.poll();
            if (other.contains(cur)) {
                return true;
            }
            for (String next : nextRotate(cur)) {
                if (!memory.contains(next) && !locks.contains(next)) {
                    lane.offer(next);
                    memory.add(next);
                }
            }
        }
        return false;
    }


    private int oneWayBFS(Set<String> locks, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;

        Set<String> memory = new HashSet<>();
        memory.add("0000");

        int layer;
        String top;
        while (!queue.isEmpty()) {
            ++step;
            layer = queue.size();
            for (int i = 0; i < layer; ++i) {
                top = queue.poll();
                for (String nextStatus : nextRotate(top)) {
                    if (!memory.contains(nextStatus) && !locks.contains(nextStatus)) {
                        if (target.equals(nextStatus)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        memory.add(nextStatus);
                    }
                }
            }

        }
        return -1;
    }


    private List<String> nextRotate(String status) {
        List<String> result = new LinkedList<>();
        char[] data = status.toCharArray();
        char[] temp;
        for (int i = 0; i < data.length; ++i) {
            temp = data.clone();
            if (temp[i] == '0') {
                temp[i] = '9';
            } else {
                --temp[i];
            }
            result.add(new String(temp));
            temp = data.clone();
            if (temp[i] == '9') {
                temp[i] = '0';
            } else {
                ++temp[i];
            }
            result.add(new String(temp));
        }
        return result;
    }


}
