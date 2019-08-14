public class lc312_BurstBalloons_DP {
    static class Solution {
        public int maxCoins(int[] nums) {
            int n = 1;
            for (int i :nums) {
                if (i > 0) n++;
            }
            int[] nums2 = new int[n + 1];
            n = 1;
            for (int i: nums) {
                if (i > 0) nums2[n++] = i;
            }
            nums2[0] = 1;
            nums2[n++] = 1;

            int[][] dp = new int[n][n];
            for (int len = 2; len < n; len++) {
                for (int left = 0; left < n - len; left++) {
                    int right = left + len;
                    for (int last_burst = left + 1; last_burst < right; last_burst++) {
                        dp[left][right] = Math.max(dp[left][right], dp[left][last_burst] + nums2[left] * nums2[last_burst] * nums2[right] + dp[last_burst][right]);
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        Solution tool = new Solution();
        int result = tool.maxCoins(nums);
        System.out.println(result);
    }
}
