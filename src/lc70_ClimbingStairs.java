public class lc70_ClimbingStairs {
    static class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Solution tool = new Solution();
        int result = tool.climbStairs(n);
        System.out.println(result);
    }
}
