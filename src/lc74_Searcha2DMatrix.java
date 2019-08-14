public class lc74_Searcha2DMatrix {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) return false;
            int[] col0 = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                col0[i] = matrix[i][0];
            }
            int r_index = binarySearchloc(col0, 0, col0.length - 1, target);
            int c_index = binarySearchloc(matrix[r_index], 0, matrix[r_index].length - 1, target);
            return matrix[r_index][c_index] == target;
        }

        public int binarySearchloc(int[] nums, int l, int r, int target) {
            if (l >= r) {
                if (nums[l] == target) {
                    return l;
                } else if (nums[l] < target) {
                    return l;
                } else {
                    return l > 0 ? l - 1 : 0;
                }
            }
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return binarySearchloc(nums, mid + 1, r, target);
            } else {
                return binarySearchloc(nums, l , mid - 1, target);
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3}};
        int target = 3;
        Solution tool = new Solution();
        boolean result = tool.searchMatrix(matrix, target);
        System.out.println(result);
    }
}
