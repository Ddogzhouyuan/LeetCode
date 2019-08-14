import static com.TreenodeUtil.*;
public class lc96_UniqueBinarySearchTrees {
    static class Solution {
        public int numTrees(int n) {
            if (n < 1) return 0;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[i - 1 - j] * dp[j];
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Solution tool = new Solution();
        int result = tool.numTrees(n);
        System.out.println(result);
    }
}
