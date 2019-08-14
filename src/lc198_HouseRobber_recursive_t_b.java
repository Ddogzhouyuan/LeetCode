public class lc198_HouseRobber_recursive_t_b {
    static class Solution {
        public int rob(int[] nums) {
            return helper(nums, nums.length - 1);
        }

        public int helper(int[] nums, int i) {
            if (i < 0) {
                return 0;
            }
            return Math.max(helper(nums, i - 2) + nums[i], helper(nums, i - 1));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution tool = new Solution();
        int result = tool.rob(nums);
        System.out.println(result);
    }
}
