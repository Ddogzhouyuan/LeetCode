public class lc5_LongestPalindromicSubstring {
    static class Solution {
        public String longestPalindrome(String s) {
            if (s.isEmpty()) return s;
            int n = s.length();
            int start = 0;
            int end = 0;
            boolean[][] p = new boolean[n][n];
            for (int i = n - 2; i >= 0; i--) {
                p[i][i] = true;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i < 3 || p[i + 1][j - 1])) {
                        p[i][j] = true;
                    } else {
                        p[i][j] = false;
                    }
                    if (p[i][j] && (end - start < j - i)) {
                        end = j;
                        start = i;
                    }
                }
            }
            return s.substring(start, end + 1);
        }
    }
}
