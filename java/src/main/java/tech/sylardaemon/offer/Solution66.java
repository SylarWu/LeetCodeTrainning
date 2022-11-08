package tech.sylardaemon.offer;

public class Solution66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 1){
            return a;
        }
        int n = a.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = a[0];
        suffix[n - 1] = a[n - 1];
        for (int i = 1; i < n; ++i){
            prefix[i] = prefix[i - 1] * a[i];
            suffix[n - 1 - i] = suffix[n - i] * a[n - 1 - i];
        }
        int[] result = new int[n];
        result[0] = suffix[1];
        result[n - 1] = prefix[n - 2];
        for (int i = 1; i < n - 1; ++i){
            result[i] = prefix[i - 1] * suffix[i + 1];
        }
        return result;
    }

    private int[] o1_space_method(int[] a){
        if (a == null || a.length <= 1){
            return a;
        }
        int n = a.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; ++i){
            result[i] = result[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = n - 2; i >= 0; --i){
            temp *= a[i + 1];
            result[i] *= temp;
        }
        return result;
    }
}
