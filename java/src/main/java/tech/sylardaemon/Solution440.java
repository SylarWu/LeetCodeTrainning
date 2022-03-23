package tech.sylardaemon;

public class Solution440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        int prefix = 1;
        while (cur < k){
            // 获取prefix做前缀的节点个数
            int count = getCnt(prefix, n);
            if (cur + count <= k){
                // 寻找的第k个不在当前前缀下，则到平行节点寻找
                ++prefix;
                cur += count;
            }else {
                // 寻找的第k个在当前前缀下，则下一层
                prefix *= 10;
                ++cur;
            }
        }
        return prefix;
    }

    private int getCnt(int prefix, int limit){
        String prefixStr = String.valueOf(prefix);
        String limitStr = String.valueOf(limit);
        int n = prefixStr.length(), m = limitStr.length();
        int k = m - n;
        int result = 0;
        int u = Integer.parseInt(limitStr.substring(0, n));
        for (int i = 0; i < k; i++){
            result += Math.pow(10, i);
        }
        if (u > prefix){
            result += Math.pow(10, k);
        }else if (u == prefix){
            result += limit - prefix * Math.pow(10, k) + 1;
        }
        return result;
    }
}
