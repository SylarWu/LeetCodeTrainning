package tech.sylardaemon;

public class Solution179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] data = new String[n];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; ++i){
            data[i] = String.valueOf(nums[i]);
        }
        quickSortByDict(data,0,n - 1);
        if (data[0].equals("0")){
            return "0";
        }
        for (int i = 0; i < n; ++i){
            res.append(data[i]);
        }
        return res.toString();
    }

    private void quickSortByDict(String[] data,int begin,int end){
        if (begin >= end){
            return;
        }
        String pivot = new String(data[begin]);
        int i = begin;
        int j = end;
        while (i < j){
            while ( i < j && compare(data[j] + pivot,pivot + data[j]) >= 0){
                --j;
            }
            data[i] = data[j];
            while ( i < j && compare(data[i] + pivot,pivot + data[i]) <= 0){
                ++i;
            }
            data[j] = data[i];
        }
        data[i] = pivot;
        quickSortByDict(data,begin,i - 1);
        quickSortByDict(data,i + 1,end);
    }

    private int compare(String a,String b){
        int len_a = a.length();
        int len_b = b.length();
        int i = 0;
        while (i < len_a && i < len_b){
            if (a.charAt(i) == b.charAt(i)){
                ++i;
            }else if (a.charAt(i) > b.charAt(i)){
                return -1;
            }else {
                return 1;
            }
        }
        return 0;
    }
}
