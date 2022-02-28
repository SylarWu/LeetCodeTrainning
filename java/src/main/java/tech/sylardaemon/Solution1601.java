package tech.sylardaemon;


public class Solution1601 {

    public int maximumRequests(int n, int[][] requests) {
//        return brutalForceBacktraceMethod(n, requests);
        return circleCountMethod(n, requests);
    }

    private int circleCountMethod(int n, int[][] requests){
        int result = 0;
        int[][] fromTo = new int[n][n];
        for (int[] request : requests){
            if (request[0] == request[1]){
                ++result;
                continue;
            }
            ++fromTo[request[0]][request[1]];
        }
        for (int i = 0; i < n; ++i) {
            int circle;
            do {
                circle = findLoop(fromTo, i, i, 0);
                result += circle;
            } while (circle != 0);
        }
        return result;
    }

    private int findLoop(int[][] fromTo, int begin, int cur, int pathCount){
        if (pathCount == 0 || begin != cur){
            int maxPathCountIndex = -1;
            int maxPathCount = 0;
            for (int i = 0; i < fromTo.length; ++i){
                int supportCircle = fromTo[cur][i];
                if (supportCircle > 0){
                    --fromTo[cur][i];
                    int tempPathCount = findLoop(fromTo, begin, i, pathCount + 1);
                    if (tempPathCount > maxPathCount){
                        maxPathCount = tempPathCount;
                        maxPathCountIndex = i;
                    }
                    ++fromTo[cur][i];

                }
            }
            if (maxPathCountIndex == -1){
                return 0;
            }else{
                --fromTo[cur][maxPathCountIndex];
                return maxPathCount;
            }
        }
        return pathCount;
    }

    private int brutalForceBacktraceMethod(int n, int[][] requests){
        int[] counts = new int[n];
        return dfsBacktrace(counts, requests, 0, 0);
    }

    private int dfsBacktrace(int[] counts, int[][] request, int index, int result){
        if (index == request.length){
            for (int count : counts){
                if (count != 0){
                    return 0;
                }
            }
            return result;
        }
        int pick = 0;
        --counts[request[index][0]];
        ++counts[request[index][1]];
        pick = Math.max(pick, dfsBacktrace(counts, request, index + 1, result + 1));
        ++counts[request[index][0]];
        --counts[request[index][1]];
        return Math.max(pick, dfsBacktrace(counts, request, index + 1, result));
    }
}
