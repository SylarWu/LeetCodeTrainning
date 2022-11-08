package tech.sylardaemon.offer;

public class Solution44 {
    public int findNthDigit(int n) {
        if (n < 10){
            return n;
        }
        int start = 1, length = 1;
        long count = start * length * 9;
        while (n > count){
            n = (int) (n - count);
            start *= 10;
            length += 1;
            count = (long) start * length * 9;
        }
        int num = start + ((n - 1) / length);
        int index = (n - 1) % length;
        for (int i = length - 1; i > index; --i){
            num /= 10;
        }
        return num % 10;
    }
}
