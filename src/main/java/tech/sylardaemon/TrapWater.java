package tech.sylardaemon;

public class TrapWater {
    public int trap(int[] height) {
        return doublePointer(height);
    }

    private int bruteForce(int[] height){
        int res = 0;
        int max_left,max_right;
        for (int i = 1; i < height.length - 1; ++i){
            max_left = i;
            max_right = i;
            for (int j = i - 1; j >= 0; --j){
                max_left = height[j] > height[max_left] ? j : max_left;
            }
            for (int j = i + 1; j < height.length; ++j){
                max_right = height[j] > height[max_right] ? j : max_right;
            }
            res += (height[max_left] < height[max_right] ? (height[max_left] - height[i]) : (height[max_right] - height[i]));

        }
        return res;
    }

    private int dynamicPrograming(int[] height){
        if (height == null || height.length < 2){
            return 0;
        }
        int res = 0;
        int n = height.length;
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        max_left[0] = 0;
        max_right[n - 1] = n - 1;
        for (int i = 1; i < n; ++i){
            max_left[i] = height[i] > height[max_left[i - 1]] ? i : max_left[i - 1];
        }
        for (int i = n - 2; i >= 0; --i){
            max_right[i] = height[i] > height[max_right[i + 1]] ? i : max_right[i + 1];
        }
        for (int i = 1; i < n - 1; ++i){
            res += (height[max_left[i]] < height[max_right[i]] ? (height[max_left[i]] - height[i]) : (height[max_right[i]] - height[i]));
        }
        return res;
    }


    private int doublePointer(int[] height){
        int res = 0;
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] >= left_max){
                    left_max = height[left];
                }else{
                    res += (left_max - height[left]);
                }
                ++left;
            }else{
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    res += (right_max - height[right]);
                }
                --right;
            }
        }
        return res;
    }
}
