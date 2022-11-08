package tech.sylardaemon.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution38 {
    public String[] permutation(String s) {
        return next_permutation_method(s);
    }

    private String[] next_permutation_method(String s) {
        char[] data = s.toCharArray();
        List<String> permute = new LinkedList<>();
        Arrays.sort(data);
        do {
            permute.add(new String(data));
        } while(next_permutation(data));
        int i = 0;
        String[] result = new String[permute.size()];
        for (String str: permute){
            result[i++] = str;
        }
        return result;
    }

    private boolean next_permutation(char[] data){
        int i = data.length - 2;
        while (i >= 0 && data[i] >= data[i + 1]){
            --i;
        }
        if (i < 0){
            return false;
        }
        int j = data.length - 1;
        while (j >= 0 && data[j] <= data[i]){
            --j;
        }
        swap(data, i, j);
        reverse(data, i + 1, data.length - 1);
        return true;
    }

    private void swap(char[] data, int left, int right){
        char temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }

    private void reverse(char[] data, int left, int right){
        char temp;
        while (left < right){
            temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            ++left;
            --right;
        }
    }


    private String[] backtrace_method(String s){
        char[] data = s.toCharArray();
        Arrays.sort(data);
        List<String> permute = new LinkedList<>();
        recursive(permute, data, new StringBuffer(), new boolean[s.length()]);
        int i = 0;
        String[] result = new String[permute.size()];
        for (String str: permute){
            result[i++] = str;
        }
        return result;
    }

    private void recursive(List<String> result, char[] data, StringBuffer temp, boolean[] visited){
        if (temp.length() == data.length){
            result.add(temp.toString());
            return;
        }
        for (int i = 0; i < data.length; ++i){
            if (visited[i] || (i > 0 && !visited[i - 1] && data[i-1] == data[i])){
                continue;
            }
            visited[i] = true;
            temp.append(data[i]);
            recursive(result, data, temp, visited);
            visited[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
