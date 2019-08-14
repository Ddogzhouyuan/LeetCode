public class lc200_NumberofIslands {
    static class Solution {
        boolean[][] type;
        public int numIslands(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            int m = grid.length, n = grid[0].length;
            type = new boolean[m][n];
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!type[i][j] && grid[i][j] == '1') {
                        dfs(grid, i, j, type);
                        count++;
                    }
                }
            }
            return count;
        }

        public void dfs(char[][] grid, int i, int j, boolean[][] type) {
            if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !type[i][j] && grid[i][j] == '1') {
                type[i][j] = true;
                dfs(grid, i + 1, j, type);
                dfs(grid, i, j + 1, type);
                dfs(grid, i - 1, j, type);
                dfs(grid, i, j - 1, type);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Solution tool = new Solution();
        int result = tool.numIslands(grid);
        System.out.println(result);
    }
}
