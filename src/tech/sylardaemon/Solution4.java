package tech.sylardaemon;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return firstInMyHead(nums1,nums2);
    }
    private double firstInMyHead(int[] nums1,int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0;
        int left = -1,right = -1;
        for (int k = 0; k <= (m + n) / 2; ++k){
            left = right;
            if (i == m){
                right = nums2[j++];
            }else if (j == n){
                right = nums1[i++];
            }else if (nums1[i] <= nums2[j]){
                right = nums1[i++];
            }else{
                right = nums2[j++];
            }
        }
        boolean isEven = ((m + n) % 2) == 0;
        if (isEven){
            return (left + right) * 0.5;
        }else{
            return right;
        }
    }
}
