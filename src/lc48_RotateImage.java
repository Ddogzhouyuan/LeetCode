public class lc48_RotateImage {
    static class Solution {
        public void rotate(int[][] matrix) {
            int start = 0;
            int end = matrix.length - 1;
            while (start < end) {
                int[] temp = matrix[start];
                matrix[start] = matrix[end];
                matrix[end] = temp;
                start++;
                end--;
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i + 1; j < matrix[0].length; j++) {
                    swap(matrix, i, j);
                }
            }
        }

        private void swap(int[][] matrix, int i, int j) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}
