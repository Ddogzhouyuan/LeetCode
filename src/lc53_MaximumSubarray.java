public class lc53_MaximumSubarray {
    static class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) return nums[0];
            int sum = 0;
            int result = nums[0];
            for (int i = 0; i < nums.length; i++) {
                sum = Math.max(sum + nums[i], nums[i]);
                result = Math.max(sum, result);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1};
        Solution tool = new Solution();
        int result = tool.maxSubArray(nums);
        System.out.println(result);
    }
}
