package LeetCode_CN;

public class lc378_KthSmallestElementinaSortedMatrix {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int l = matrix[0][0];
            int r = matrix[m - 1][n - 1] + 1;
            while (l < r) {
                int mid = l + (r - l) /2;
                int j = n - 1;
                int count = 0;
                for (int i = 0; i < m; i++) {
                    while (j >= 0 && matrix[i][j] > mid) {
                        j--;
                    }
                    count += (j + 1);
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
}
