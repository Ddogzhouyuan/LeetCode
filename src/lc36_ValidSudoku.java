import java.util.HashSet;

public class lc36_ValidSudoku {
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            HashSet<String> seen = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        if (!seen.add(num + " in row " + i) || !seen.add(num + " in col " + j) || !seen.add(num + "in block " + i / 3 + " " + j / 3)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Solution tool = new Solution();
        boolean result = tool.isValidSudoku(board);
        System.out.println(result);
    }
}
