public class lc213_HouseRobberII {
    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            int[] nums1 = new int[nums.length];
            int[] nums2 = new int[nums.length];

            for (int i = 0; i < nums.length - 1; i++) {
                int j = i + 1;
                nums1[i] = nums[i];
                nums2[i] = nums[j];
            }
            return Math.max(helper(nums1), helper(nums2));
        }

        public int helper(int[] nums) {
            if (nums.length == 0) return 0;
            int[] memo = new int[nums.length + 1];
            memo[0] = 0;
            memo[1] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int val = nums[i];
                memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
            }
            return memo[nums.length];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        Solution tool = new Solution();
        int result = tool.rob(nums);
        System.out.println(result);
    }
}
