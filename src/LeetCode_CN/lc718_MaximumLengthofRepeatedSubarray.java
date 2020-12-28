package LeetCode_CN;

public class lc718_MaximumLengthofRepeatedSubarray {
    static class Solution {
        public int findLength(int[] A, int[] B) {
            int ALen = A.length;
            int BLen = B.length;
            if (ALen == 0 || BLen == 0) {
                return 0;
            }
            int[][] dp = new int[ALen + 1][BLen + 1];
            int result = 0;
            for (int i = 1; i <= ALen; i++) {
                for (int j = 1; j <= BLen; j++) {
                    dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                    result = Math.max(dp[i][j], result);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        Solution tool = new Solution();
        int result = tool.findLength(A, B);
        System.out.println(result);
    }
}
