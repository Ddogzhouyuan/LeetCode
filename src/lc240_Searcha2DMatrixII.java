public class lc240_Searcha2DMatrixII {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

            int m = matrix.length, n = matrix[0].length;
            int i = 0, j = n - 1;
            while (i < m && j >= 0) {
                int num = matrix[i][j];
                if (num == target) {
                    return true;
                } else if (num < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int target = 20;
        Solution tool = new Solution();
        boolean result = tool.searchMatrix(matrix, target);
        System.out.println(result);
    }
}
