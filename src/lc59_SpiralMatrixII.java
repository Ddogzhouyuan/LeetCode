import java.util.Arrays;

public class lc59_SpiralMatrixII {
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            if (n == 0) return matrix;
            int count = 1;
            int rowBegin = 0, rowEnd = matrix.length - 1;
            int colBegin = 0, colEnd = matrix[0].length - 1;
            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                for (int i = colBegin; i <= colEnd; i++) {
                    matrix[rowBegin][i] = count++;
                }
                rowBegin++;
                for (int i = rowBegin; i <= rowEnd; i++) {
                    matrix[i][colEnd] = count++;
                }
                colEnd--;
                if (rowBegin <= rowEnd) {
                    for (int i = colEnd; i >= colBegin; i--) {
                        matrix[rowEnd][i] = count++;
                    }
                }
                rowEnd--;
                if (colBegin <= colEnd) {
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        matrix[i][colBegin] = count++;
                    }
                }
                colBegin++;
            }
            return matrix;
        }
    }

    public static void main(String[] args) {
        int n = 9;
        Solution tool = new Solution();
        int[][] matrix = tool.generateMatrix(n);
        for (int[] i: matrix) {
            System.out.println(Arrays.toString(i));
        }
    }
}
