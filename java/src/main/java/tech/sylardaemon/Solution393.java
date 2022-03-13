package tech.sylardaemon;

public class Solution393 {
    public boolean validUtf8(int[] data) {
        int begin = 0;
        while (begin < data.length){
            boolean flag = true;
            int length = validLength(data[begin]);
            if (length == 1 || length > 4 || begin + length > data.length){
                return false;
            }
            if (length == 0){
                ++begin;
                continue;
            }
            for (int i = begin + 1; i < begin + length; ++i){
                flag = flag && validHead(data[i]);
            }
            if (!flag){
                return false;
            }
            begin += length;
        }
        return true;
    }

    private int validLength(int digit){
        int shift = 7;
        while (shift >= 0 && ((digit >> shift) & 1) == 1){
            --shift;
        }
        return 7 - shift;
    }

    private boolean validHead(int digit){
        return ((digit >> 7) & 1) == 1 && ((digit >> 6) & 1) == 0;
    }
}
