import java.util.Arrays;

public class lc300_LongestIncreasingSubsequence_DP {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        max = Math.max(max, dp[i]);
                    }
                }
            }
            return Math.max(max, dp[nums.length - 1]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        Solution tool = new Solution();
        int result = tool.lengthOfLIS(nums);
        System.out.println(result);
    }
}
