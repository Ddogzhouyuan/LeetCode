import java.util.*;

public class lc349_IntersectionofTwoArrays {
    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if (n1 < n2) {
                Arrays.sort(nums2);
                return helper(nums1, nums2);
            } else {
                Arrays.sort(nums1);
                return helper(nums2, nums1);
            }
        }

        public int[] helper(int[] shorter, int[] longer) {
            List<Integer> resultls = new ArrayList<>();
            for (int i = 0; i < shorter.length; i++) {
                int target = shorter[i];
                if (resultls.contains(target)) {
                    continue;
                } else {
                    int searchresult = binarySearch(longer, 0, longer.length - 1, target);
                    if (searchresult >= 0) resultls.add(target);
                }
            }
            int[] result = new int[resultls.size()];
            for (int i = 0; i < resultls.size(); i++) {
                result[i] = resultls.get(i);
            }
            return result;
        }

        public int binarySearch(int[] nums, int l, int h, int target) {
            if (l > h) return -1;
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearch(nums, l, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, h, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Solution tool = new Solution();
        int[] result = tool.intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
