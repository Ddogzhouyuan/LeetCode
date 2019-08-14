import java.util.ArrayList;
import java.util.List;

public class lc54_SpiralMatrix {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if (matrix.length == 0 || matrix[0].length == 0) return result;
            int rowBegin = 0, colBegin = 0;
            int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;

            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                for (int i = colBegin; i <= colEnd; i++) {
                    result.add(matrix[rowBegin][i]);
                }
                rowBegin++;
                for (int i = rowBegin; i <= rowEnd; i++) {
                    result.add(matrix[i][colEnd]);
                }
                colEnd--;
                if (rowBegin <= rowEnd) {
                    for (int i = colEnd; i >= colBegin; i--) {
                        result.add(matrix[rowEnd][i]);
                    }
                }
                rowEnd--;
                if (colBegin <= colEnd) {
                    for (int i = rowEnd; i >= rowBegin; i--) {
                        result.add(matrix[i][colBegin]);
                    }
                }
                colBegin++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution tool = new Solution();
        List<Integer> result = tool.spiralOrder(matrix);
        System.out.println(result.toString());
    }
}
