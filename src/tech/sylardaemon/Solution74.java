package tech.sylardaemon;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        int middle;
        while (left <= right){
            middle = (left + right) / 2;
            if (matrix[middle][0] <= target && target <= matrix[middle][n - 1]){
                return biSearch(matrix[middle],target);
            }else if (target < matrix[middle][0]){
                right = middle - 1;
            }else if (target > matrix[middle][n - 1]){
                left = middle + 1;
            }
        }
        return false;
    }

    private boolean biSearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right){
            middle = (left + right) / 2;
            if (target == nums[middle]){
                return true;
            }else if (target > nums[middle]){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return false;
    }
}
