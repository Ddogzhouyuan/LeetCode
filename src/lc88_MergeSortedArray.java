import java.util.Arrays;

public class lc88_MergeSortedArray {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] temp = new int[m];
            for (int i = 0; i < m; i++) temp[i] = nums1[i];
            int left = 0;
            int right = 0;
            for (int i = 0; i < m + n; i++) {
                if (left < m && right < n  && temp[left] <= nums2[right]) {
                    nums1[i] = temp[left++];
                } else if (left < m && right < n && nums2[right] <= temp[left]) {
                    nums1[i] = nums2[right++];
                } else if (left >= m) {
                    nums1[i] = nums2[right++];
                } else {
                    nums1[i] = temp[left++];
                }
            }
            System.out.println(Arrays.toString(nums1));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Solution tool = new Solution();
        tool.merge(nums1, m, nums2, n);
    }
}
