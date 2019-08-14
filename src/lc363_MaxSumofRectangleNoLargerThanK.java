import java.util.TreeSet;

public class lc363_MaxSumofRectangleNoLargerThanK {
    static class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
            if (matrix.length == 0 || matrix[0].length == 0) return 0;
            int rows = matrix.length;
            int cols = matrix[0].length;
            int[][] areas = new int[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int area = matrix[r][c];
                    if (r - 1 >= 0) area += areas[r - 1][c];
                    if (c - 1 >= 0) area += areas[r][c - 1];
                    if (r - 1 >= 0 && c - 1 >= 0) area -= areas[r - 1][c - 1];
                    areas[r][c] = area;
                }
            }

            int max = Integer.MIN_VALUE;
            for (int r1 = 0; r1 < rows; r1++) {
                for (int r2 = r1; r2 < rows; r2++) {
                    TreeSet<Integer> treeset = new TreeSet<>();
                    treeset.add(0);
                    for (int c = 0; c < cols; c++) {
                        int area = areas[r2][c];
                        if (r1 - 1 >= 0) area -= areas[r1 - 1][c];
                        Integer ceiling = treeset.ceiling(area - k);
                        if (ceiling != null) {
                            max = Math.max(max, area - ceiling);
                        }
                        treeset.add(area);
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1}, {0,-2,3}};
        int k = 2;
        Solution tool = new Solution();
        int result = tool.maxSumSubmatrix(matrix, k);
        System.out.println(result);
    }
}
