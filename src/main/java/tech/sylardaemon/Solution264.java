package tech.sylardaemon;

public class Solution264 {

    private static final int[] lookup = new int[1691];
    private static final int[] factor = new int[]{2,3,5};

    static {
        lookup[1] = 1;
        int count = 2;
        int temp;
        int num2,num3,num5;
        int p2 = 1, p3 = 1, p5 = 1;
        while (count <= 1690){
            num2 = lookup[p2] * factor[0];
            num3 = lookup[p3] * factor[1];
            num5 = lookup[p5] * factor[2];
            lookup[count] = Math.min(Math.min(num2,num3),num5);
            if (lookup[count] == num2){
                ++p2;
            }
            if (lookup[count] == num3){
                ++p3;
            }
            if (lookup[count] == num5){
                ++p5;
            }
            ++count;
        }
    }


    public int nthUglyNumber(int n) {
        for (int i = 1; i <= 1690; ++i){
            System.out.print(lookup[i]);
            System.out.print(",");
        }
        return lookup[n];
    }
}
