public class lc377_CombinationSumIV_recursive {
    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            if (target == 0) return 1;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= target) {
                    res += combinationSum4(nums, target - nums[i]);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int target = 32;
        Solution tool = new Solution();
        int result = tool.combinationSum4(nums, target);
        System.out.println(result);
    }
}
