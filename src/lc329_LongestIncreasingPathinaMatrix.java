public class lc329_LongestIncreasingPathinaMatrix {
    static class Solution {
        int[][] dp;
        public int longestIncreasingPath(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;
            int m = matrix.length, n = matrix[0].length;
            dp = new int[m][n];
            int result = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result = Math.max(result, dfs(matrix, i, j));
                }
            }
            return result;
        }

        public int dfs(int[][] matrix, int i, int j) {
            if (dp[i][j] > 0) return dp[i][j];
            int res = 1;
            if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) res = Math.max(res, 1 + dfs(matrix, i + 1, j));
            if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) res = Math.max(res, 1 + dfs(matrix, i - 1, j));
            if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) res = Math.max(res, 1 + dfs(matrix, i, j + 1));
            if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) res = Math.max(res, 1 + dfs(matrix, i, j - 1));
            dp[i][j] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        Solution tool = new Solution();
        int result = tool.longestIncreasingPath(matrix);
        System.out.println(result);
    }
}
