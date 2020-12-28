package LeetCode_CN;

public class lc64_MinimumPathSum {
    static class Solution {
        public int minPathSum(int[][] grid) {
            int result = 0;
            if (grid.length <= 1) {
                for (int i = 0; i < grid[0].length; i++) {
                    result += grid[0][i];
                }
                return result;
            }
            if (grid[0].length <= 1) {
                for (int i = 0; i < grid.length; i++) {
                    result += grid[i][0];
                }
                return result;
            }
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                    } else if (i == 0 && j > 0) {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    } else if (j == 0 && i > 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Solution tool = new Solution();
        int result = tool.minPathSum(grid);
        System.out.println(result);
    }
}
