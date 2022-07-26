package tech.sylardaemon.offer;

public class Solution11 {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        int middle;
        while (left < right){
            middle = left + (right - left) / 2;
            if (numbers[middle] > numbers[right]){
                left = middle + 1;
            }else if (numbers[middle] < numbers[right]){
                right = middle;
            }else {
                --right;
            }
        }
        return numbers[left];
    }

    private int simpleIdea(int[] numbers){
        int i = 0, j = numbers.length - 1;
        int result = numbers[i];
        while (i < j){
            if (numbers[i] > numbers[i + 1]){
                return numbers[i + 1];
            }else if (numbers[j - 1] > numbers[j]){
                return numbers[j];
            }
            ++i;
            --j;
        }
        return result;
    }
}
