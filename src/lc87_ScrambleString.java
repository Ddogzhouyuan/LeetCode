public class lc87_ScrambleString {
    static class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1 == null || s2 == null) return false;
            int m = s1.length();
            int n = s2.length();
            if (m != n) return false;

            boolean[][][] dp = new boolean[m][m][m + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                }
            }

            for (int k = 2; k <= m; k++) {
                for (int i = 0; i <= m - k; i++) {
                    for (int j = 0; j <= m - k; j++) {
                        for (int l = 1; l < k; l++) {
                            if ((dp[i][j][l] && dp[i + l][j + l][k - l]) || (dp[i][j + k - l][l] && dp[i + l][j][k - l])) {
                                dp[i][j][k] = true;
                            }
                        }
                    }
                }
            }

            return dp[0][0][m];
        }
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        Solution tool = new Solution();
        boolean result = tool.isScramble(s1, s2);
        System.out.println(result);
    }
}
