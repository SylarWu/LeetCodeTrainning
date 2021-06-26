package tech.sylardaemon;

import java.lang.management.MemoryManagerMXBean;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Solution127 {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> permission = new HashSet<>();
        for (String s : wordList) {
            permission.add(s);
        }
        if (!permission.contains(endWord)) {
            return 0;
        }
        return twoWayBFS(beginWord, endWord, permission);
    }


    private int twoWayBFS(String begin, String end, Set<String> permission) {
        Queue<String> topLane = new LinkedList<>();
        HashMap<String, Integer> topMemory = new HashMap<>();
        topLane.offer(begin);
        topMemory.put(begin, 0);

        Queue<String> botLane = new LinkedList<>();
        HashMap<String, Integer> botMemory = new HashMap<>();
        botLane.offer(end);
        botMemory.put(end, 0);

        int result;

        while (!topLane.isEmpty() && !botLane.isEmpty()) {
            result = -1;

            if (topLane.size() <= botLane.size()) {
                result = update(topLane, topMemory, botMemory, permission);
            } else {
                result = update(botLane, botMemory, topMemory, permission);
            }

            if (result != -1) {
                return result + 1;
            }
        }
        return 0;
    }

    private int update(Queue<String> lane, HashMap<String, Integer> memory, HashMap<String, Integer> other, Set<String> permission) {
        String cur = lane.poll();
        int curStep = memory.get(cur);
        List<String> nexts = nextState(cur, permission, memory);
        for (String next : nexts) {
            if (other.containsKey(next)) {
                return curStep + other.get(next) + 1;
            } else {
                lane.offer(next);
                memory.put(next, curStep + 1);
            }
        }
        return -1;
    }


    private List<String> nextState(String current, Set<String> permission, HashMap<String, Integer> memory) {
        List<String> result = new LinkedList<>();
        int length = current.length();
        String next;
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < 26; ++j) {
                next = current.substring(0, i) + String.valueOf((char) ('a' + j)) + current.substring(i + 1);
                if (permission.contains(next) && !memory.containsKey(next)) {
                    result.add(next);
                }
            }
        }
        return result;
    }

}
