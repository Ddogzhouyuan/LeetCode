import java.util.Arrays;

public class lc130_SurroundedRegions {
    static class Solution {
        public void solve(char[][] board) {
            if (board.length == 0 || board[0].length == 0) return;
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                dfs(board, i, 0);
                dfs(board, i, n - 1);
            }
            for (int j = 0; j < n; j++) {
                dfs(board, 0, j);
                dfs(board, m - 1, j);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '1') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }

        }

        public void dfs(char[][] board, int i, int j) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
                return;
            } else if (board[i][j] == 'O') {
                board[i][j] = '1';
                dfs(board, i + 1, j);
                dfs(board, i, j + 1);
                dfs(board, i - 1, j);
                dfs(board, i, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Solution tool = new Solution();
        tool.solve(board);
        for (char[] i: board) {
            System.out.println(Arrays.toString(i));
        }
    }
}
