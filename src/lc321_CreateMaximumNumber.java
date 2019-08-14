import java.util.Arrays;
import java.util.Stack;

public class lc321_CreateMaximumNumber {
    static class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int[] result = new int[k];
            for (int i = Math.max(0, k - nums2.length); i <= k && i <= nums1.length; ++i) {
                int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
                if (greater(candidate, 0, result, 0)) result = candidate;
            }
            return result;
        }

        public int[] maxArray(int[] nums, int k) {
            Stack<Integer> stack1 = new Stack<>();
            for (int i = 0; i < nums.length; i++) {
                while (!stack1.empty() && nums.length - i + stack1.size() > k && stack1.peek() < nums[i]) stack1.pop();
                if (stack1.size() < k) stack1.push(nums[i]);
            }
            int[] result = new int[k];
            for (int i = k - 1; i >= 0; i--) result[i] = stack1.pop();
            return result;
        }

        public boolean greater(int[] nums1, int i, int[] nums2, int j) {
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                i++;
                j++;
            }
            boolean result = j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
            return result;
        }

        public int[] merge(int[] nums1, int[] nums2, int k) {
            int[] result = new int[k];
            for (int i = 0, j = 0, r = 0; r < k; r++) {
                result[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
            }
            return result;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {6,7};
        int[] nums2 = {6,0,4};
        int k = 5;
        Solution tool = new Solution();
        int[] result = tool.maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(result));
    }
}
