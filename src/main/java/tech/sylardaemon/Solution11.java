package tech.sylardaemon;

public class Solution11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int temp;
        while (i < j){
            temp = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
            if (temp > max){
                max = temp;
            }
            if (height[i] < height[j]){
                ++i;
            }else{
                --j;
            }
        }
        return max;
    }
}
