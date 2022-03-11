package tech.sylardaemon;

import java.util.ArrayList;
import java.util.List;

public class Solution2049 {

    private long maxScore = 0;
    private int maxCount = 0;

    public int countHighestScoreNodes(int[] parents) {
        maxScore = 0;
        maxCount = 0;
        List<Integer>[] children = new List[parents.length];
        for (int i = 0; i < parents.length; ++i){
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < parents.length; ++i){
            if (parents[i] == -1){
                continue;
            }
            children[parents[i]].add(i);
        }
        dfs(0, children);
        return maxCount;
    }
    private int dfs(int node, List<Integer>[] children){
        if (node == -1){
            return 0;
        }
        int childrenCount = 0;
        long score = 1;
        for (int child : children[node]){
            int childCount = dfs(child, children);
            childrenCount += childCount;
            score *= zeroToOne(childCount);
        }
        score *= zeroToOne(children.length - childrenCount - 1);

        if (score == maxScore){
            ++maxCount;
        }else if (score > maxScore){
            maxScore = score;
            maxCount = 1;
        }
        return childrenCount + 1;
    }

    private int zeroToOne(int x){
        return x == 0 ? 1 : x;
    }
}
