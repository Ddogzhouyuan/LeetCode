import java.util.ArrayList;
import java.util.List;

public class lc52_NQueensII {
    static class Solution {
        public int totalNQueens(int n) {
            List<Integer> result = new ArrayList<>();
            boolean[] cols = new boolean[n];
            boolean[] d1 = new boolean[2 * n];
            boolean[] d2 = new boolean[2 * n];
            int count = backtrack(0, cols, d1, d2, n, 0);
            return count;
        }

        public int backtrack(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n, int count) {
            if (row == n) {
                count++;
            } else {
                for (int col = 0; col < n; col++) {
                    int id1 = row - col + n;
                    int id2 = row + col;
                    if (cols[col] || d1[id1] || d2[id2]) {
                        continue;
                    }
                    cols[col] = true;
                    d1[id1] = true;
                    d2[id2] = true;
                    count = backtrack(row + 1, cols, d1, d2, n, count);
                    cols[col] = false;
                    d1[id1] = false;
                    d2[id2] = false;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Solution tool = new Solution();
        int count = tool.totalNQueens(n);
        System.out.println(count);
    }
}
