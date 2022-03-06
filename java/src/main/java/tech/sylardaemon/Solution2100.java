package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        return dpMethodII(security, time);
    }

    private List<Integer> dpMethodII(int[] security, int time){
        List<Integer> result = new LinkedList<>();
        int[] left = new int[security.length];
        int[] right = new int[security.length];
        for (int i = 1; i < security.length; ++i){
            if (security[i - 1] >= security[i]){
                left[i] = left[i - 1] + 1;
            }
            if (security[security.length - 1 - i] <= security[security.length - i]){
                right[security.length - 1 - i] = right[security.length - i] + 1;
            }
        }
        for (int i = 0; i < security.length; ++i){
            if (left[i] >= time && right[i] >= time){
                result.add(i);
            }
        }
        return result;
    }

    private List<Integer> dpMethod(int[] security, int time){
        List<Integer> result = new LinkedList<>();
        boolean[] dp = new boolean[security.length];
        for (int i = 0; i < security.length; ++i){
            dp[i] = true;
        }
        for (int i = 1; i <= time; ++i){
            for (int j = 0; j < security.length; ++j){
                if (!dp[j]){
                    continue;
                }
                if (j - i < 0 || j + i >= security.length){
                    dp[j] = false;
                }else if (security[j - i] < security[j - i + 1] || security[j + i] < security[j + i - 1]){
                    dp[j] = false;
                }
            }
        }
        for (int i = 0; i < security.length; ++i){
            if (dp[i]){
                result.add(i);
            }
        }
        return result;
    }



    private List<Integer> brutalForceMethod(int[] security, int time){
        List<Integer> result = new LinkedList<>();
        for (int i = time; i < security.length - time; ++i){
            if (checkBeforeAfter(security, time, i)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean checkBeforeAfter(int[] security, int time, int index){
        if (index - time < 0 || index + time >= security.length){
            return false;
        }
        for (int i = index - time + 1; i <= index + time; ++i){
            if (i <= index && security[i - 1] < security[i]){
                return false;
            }else if (i > index && security[i - 1] > security[i]){
                return false;
            }
        }
        return true;
    }
}
