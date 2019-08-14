import java.util.HashMap;

public class lc377_CombinationSumIV_DP {
    static class Solution {
        HashMap<Integer, Integer> dp = new HashMap<>();
        public int combinationSum4(int[] nums, int target) {
            if (target == 0) return 1;
            int result = helper(nums, target);
            return result;
        }

        public int helper(int[] nums, int target) {
            if (target == 0) return 1;
            if (dp.containsKey(target)) {
                return dp.get(target);
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= target) {
                    result += helper(nums, target - nums[i]);
                }
            }
            dp.put(target, result);
            return result;
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
