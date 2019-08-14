public class lc62_UniquePaths {
    static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < m; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m ; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }

            return dp[n - 1][m - 1];
        }
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 1;
        Solution tool = new Solution();
        int result = tool.uniquePaths(m, n);
        System.out.println(result);
    }
}
