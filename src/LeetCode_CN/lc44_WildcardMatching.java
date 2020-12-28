package LeetCode_CN;

public class lc44_WildcardMatching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length();
            int pLen = p.length();
            boolean[][] dp = new boolean[sLen + 1][pLen + 1];
            dp[0][0] = true;
            for (int i = 1; i <= pLen; i++) {
                dp[0][i] = p.charAt(i - 1) == '*' ? dp[0][i - 1] : false;
            }
            for (int i = 1; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
            return dp[sLen][pLen];
        }
    }
}
