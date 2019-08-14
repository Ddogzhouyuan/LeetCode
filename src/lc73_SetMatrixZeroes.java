import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc73_SetMatrixZeroes {
    static class Solution {
        public void setZeroes(int[][] matrix) {
//            List<Integer> rows = new ArrayList<>();
//            List<Integer> cols = new ArrayList<>();
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();
            int m = matrix.length;
            int n = matrix[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }

            for (int i : rows) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
            for (int j : cols) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{0,1,2},{1,1,1}};
        Solution tool = new Solution();
        tool.setZeroes(matrix);
        for (int[] i : matrix) {
            System.out.println(Arrays.toString(i));
        }
    }
}
