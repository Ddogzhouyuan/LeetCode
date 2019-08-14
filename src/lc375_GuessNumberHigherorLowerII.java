public class lc375_GuessNumberHigherorLowerII {
    static class Solution {
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n + 1][n + 1];
            for (int length = 1; length < n; length++) {
                for (int i = 1; i + length <= n; i++) {
                    int j = i + length;
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int temp = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                        min = Math.min(temp, min);
                    }
                    dp[i][j] = min;
                }
            }
            return dp[1][n];
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Solution tool = new Solution();
        int result = tool.getMoneyAmount(n);
        System.out.println(result);
    }
}
