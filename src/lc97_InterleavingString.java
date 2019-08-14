public class lc97_InterleavingString {
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n1 = s1.length();
            int n2 = s2.length();
            if (s3.length() != n1 + n2) {
                return false;
            }
            boolean[][] dp = new boolean[n1 + 1][n2 + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n1; i++) {
                dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
            }
            for (int i = 1; i <= n2; i++) {
                dp[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1];
            }

            for (int i = 1; i <= n1; i++) {
                for (int j = 1; j <= n2; j++) {
                    int k = i + j - 1;
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
                }
            }
            return dp[n1][n2];
        }
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Solution tool = new Solution();
        boolean result = tool.isInterleave(s1, s2, s3);
        System.out.println(result);
    }
}
