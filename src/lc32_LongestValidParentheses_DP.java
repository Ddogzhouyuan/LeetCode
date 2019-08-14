public class lc32_LongestValidParentheses_DP {
    static class Solution {
        public int longestValidParentheses(String s) {
            int max = 0;
            if (s.equals("")) return 0;

            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if(i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(' && s.charAt(i) == ')') {
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] = dp[i - dp[i - 1] - 2] + 2 + dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                    max = Math.max(max, dp[i]);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        String s = "(()";
        Solution tool = new Solution();
        int result = tool.longestValidParentheses(s);
        System.out.println(result);
    }
}
