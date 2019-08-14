import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc51_NQueens {
    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] board =  new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            List<List<String>> result = new ArrayList<>();
            backtrack(board, 0, result);
            return result;
        }

        public boolean isValid(char[][] board, int x, int y) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < y; j++) {
                    if (board[i][j] == 'Q' && (Math.abs(x - i) == Math.abs(y - j) || x == i)) {
                        return false;
                    }
                }
            }
            return true;
        }

        public List<String> construct(char[][] board) {
            List<String> res = new LinkedList<>();
            for (int i = 0; i < board.length; i++) {
                String s = new String(board[i]);
                res.add(s);
            }
            return res;
        }

        public void backtrack(char[][] board, int colIndex, List<List<String>> result) {
            if (colIndex == board.length) {
                result.add(construct(board));
                return;
            }

            for (int i = 0; i < board.length; i++) {
                if (isValid(board, i ,colIndex)) {
                    board[i][colIndex] = 'Q';
                    backtrack(board, colIndex + 1, result);
                    board[i][colIndex] = '.';
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Solution tool = new Solution();
        List<List<String>> result = tool.solveNQueens(n);
        for (int i = 0; i < result.size(); i++) {
            List<String> temp = result.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.println(temp.get(j));
            }
            System.out.println("---------------");
        }
    }
}
