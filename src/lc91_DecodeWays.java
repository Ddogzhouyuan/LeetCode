public class lc91_DecodeWays {
    static class Solution {
        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[n] = 1;
            dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
            for (int i = n - 2; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    continue;
                } else {
                    dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
                }
            }
            return dp[0];
        }
    }

    public static void main(String[] args) {
        String s = "226";
        Solution tool = new Solution();
        int result = tool.numDecodings(s);
        System.out.println(result);
    }
}
