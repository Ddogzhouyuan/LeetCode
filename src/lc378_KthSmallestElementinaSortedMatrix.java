public class lc378_KthSmallestElementinaSortedMatrix {
    static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int l = matrix[0][0];
            int r = matrix[m - 1][n - 1] + 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                int count = 0;
                int j = n - 1;
                for (int i = 0; i < m; i++) {
                    while (j >= 0 && matrix[i][j] > mid) j--;
                    count += j + 1;
                }
                if (count < k) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        Solution tool = new Solution();
        int result = tool.kthSmallest(matrix, k);
        System.out.println(result);
    }
}
