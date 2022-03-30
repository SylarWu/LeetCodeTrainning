package tech.sylardaemon;

import java.util.*;

public class Solution1606 {
    class ServerStatus {
        private int index;
        private int finish;

        ServerStatus(int _index, int _finish) {
            index = _index;
            finish = _finish;
        }
    }

    class ServerGroup {
        TreeSet<Integer> available;
        PriorityQueue<ServerStatus> busy;
        int[] count;

        ServerGroup(int k) {
            available = new TreeSet<>();
            for (int i = 0; i < k; ++i){
                available.add(i);
            }
            busy = new PriorityQueue<>((server1, server2) -> server1.finish - server2.finish);
            count = new int[k];
        }

        boolean submitJob(int index, int time, int load) {
            while (!busy.isEmpty() && busy.peek().finish <= time){
                available.add(busy.poll().index);
            }
            if (available.isEmpty()){
                return false;
            }
            Integer cur = available.ceiling(index % count.length);
            if (cur == null){
                cur = available.first();
            }
            ++count[cur];
            busy.offer(new ServerStatus(cur, time + load));
            available.remove(cur);
            return true;
        }

        int maxCount() {
            int maxCount = 0;
            for (int i = 0; i < count.length; ++i) {
                maxCount = Math.max(maxCount, count[i]);
            }
            return maxCount;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> result = new LinkedList<>();
        ServerGroup serverGroup = new ServerGroup(k);
        for (int i = 0; i < arrival.length; ++i) {
            serverGroup.submitJob(i, arrival[i], load[i]);
        }
        int maxCount = serverGroup.maxCount();
        for (int i = 0; i < k; ++i){
            if (maxCount == serverGroup.count[i]){
                result.add(i);
            }
        }
        return result;
    }
}
