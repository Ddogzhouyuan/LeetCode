public class lc63_UniquePathsII {
    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;
            if (m == 1 || n == 1) {
                int tag = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (obstacleGrid[i][j] == 1) tag++;
                    }
                }
                if (tag > 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
            int[][] dp = new int[n][m];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++) {
                if (obstacleGrid[i][0] == 1) {
                    break;
                } else {
                    dp[i][0] = 1;
                }
            }

            for (int i = 0; i < m; i++) {
                if (obstacleGrid[0][i] == 1) {
                    break;
                } else {
                    dp[0][i] = 1;
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (obstacleGrid[i][j] == 1) continue;
                    dp[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j]) + (obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1]);
                }
            }
            return dp[n - 1][m - 1];
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] obstacleGrid = new int[n][m];
        obstacleGrid[1][1] = 1;
        Solution tool = new Solution();
        int result = tool.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }


}
