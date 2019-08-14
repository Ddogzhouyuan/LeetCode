import java.util.Arrays;

public class lc350_IntersectionofTwoArraysII {
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int n1 = nums1.length;
            int n2 = nums2.length;
            int[] result = new int[n1 + n2];
            int idx = 0;
            for (int i = 0, j = 0; i < n1 && j < n2; ) {
                if (nums1[i] == nums2[j]) {
                    result[idx++] = nums1[i];
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            return Arrays.copyOfRange(result, 0, idx);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Solution tool = new Solution();
        int[] result = tool.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
