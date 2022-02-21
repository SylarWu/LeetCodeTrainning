package tech.sylardaemon;

public class Solution1006 {
    public int clumsy(int N) {
        int total = 0;
        boolean neg = false;
        int temp;
        int i = N;
        for (; i >= 4; i -=4){
            temp = i * (i - 1) / (i - 2);
            if  (!neg){
                total += temp;
                neg = true;
            }else{
                total += (-temp);
            }
            total += (i - 3);
        }
        switch (i){
            case 3:
                total = total + (neg ? -6 : 6);
                break;
            case 2:
                total = total + (neg ? -2 : 2);
                break;
            case 1:
                total = total + (neg ? -1 : 1);
                break;
            default:
        }
        return total;
    }
}
