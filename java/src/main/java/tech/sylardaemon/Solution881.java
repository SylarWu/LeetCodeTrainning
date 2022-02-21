package tech.sylardaemon;

public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        quickSort(people,0,people.length - 1);
        int result = 0;
        int i = 0;
        int j = people.length - 1;
        while (i <= j){
            if (people[i] + people[j] <= limit){
                ++i;
            }
            ++result;
            --j;
        }
        return result;
    }

    private void quickSort(int[] nums,int left,int right){
        if (left >= right){
            return;
        }
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && nums[j] > pivot){
                --j;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot){
                ++i;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        quickSort(nums,left,i - 1);
        quickSort(nums,i + 1,right);
    }
}
