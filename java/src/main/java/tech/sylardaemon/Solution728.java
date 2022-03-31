package tech.sylardaemon;

import java.util.LinkedList;
import java.util.List;

public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();
        for (int i = left; i <= right; ++i){
            if (isSelfDividingNumber(i)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDividingNumber(int x){
        final int factor = 10;
        int remain = x;
        while (remain > 0){
            int r = remain % factor;
            if (r == 0 || x % r != 0){
                return false;
            }
            remain /= factor;
        }
        return true;
    }
}
