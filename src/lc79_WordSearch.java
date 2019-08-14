public class lc79_WordSearch {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            char[] word_temp = word.toCharArray();
            boolean result = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word_temp[0]) {
                        result = result || dfs(board, i, j, word_temp, 0);
                    }
                }
            }
            return result;
        }

        public boolean dfs(char[][] board, int i, int j, char[] word_temp, int idx) {
            if (idx == word_temp.length) return true;
            if (i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
            if (board[i][j] != word_temp[idx]) return false;
            board[i][j] += 256;
            boolean result = dfs(board, i + 1, j, word_temp, idx + 1) ||
                    dfs(board, i, j + 1, word_temp, idx + 1) ||
                    dfs(board,i - 1, j, word_temp, idx + 1) ||
                    dfs(board, i, j - 1, word_temp, idx + 1);
            board[i][j] -= 256;
            return result;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        Solution tool = new Solution();
        boolean result = tool.exist(board, word);
        System.out.println(result);
    }
}
