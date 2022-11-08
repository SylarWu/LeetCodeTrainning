package tech.sylardaemon.offer;

public class Solution16 {
    public double myPow(double x, int n) {
        if (x == 0){
            return 0;
        }
        long pown = n;
        if (pown < 0){
            x = 1 / x;
            pown = -pown;
        }
        double result = 1.0;
        while (pown > 0){
            if ((pown & 0x1) == 1){
                result *= x;
            }
            x *= x;
            pown = pown >> 1;
        }
        return result;
    }
}
