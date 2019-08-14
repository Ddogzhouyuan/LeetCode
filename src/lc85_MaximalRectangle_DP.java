import java.util.Arrays;

public class lc85_MaximalRectangle_DP {
    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) return 0;
            int m = matrix.length;
            int n = matrix[0].length;
            int[] left = new int[n];
            int[] right = new int[n];
            int[] height = new int[n];
            int maxA = 0;
            Arrays.fill(right, n);

            for (int i = 0; i < m; i++) {
                int cur_left = 0;
                int cut_right = n;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        height[j]++;
                    } else {
                        height[j] = 0;
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        left[j] = Math.max(left[j], cur_left);
                    } else {
                        left[j] = 0;
                        cur_left = j + 1;
                    }
                }
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '1') {
                        right[j] = Math.min(right[j], cut_right);
                    } else {
                        right[j] = n;
                        cut_right = j;
                    }
                }
                for (int j = 0; j < n; j++) {
                    maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
                }
            }
            return maxA;
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Solution tool = new Solution();
        int result = tool.maximalRectangle(matrix);
        System.out.println(result);
    }
}
