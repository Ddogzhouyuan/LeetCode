package LeetCode_CN;

import java.util.List;

public class lc120_Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            int n = triangle.get(m - 1).size();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = triangle.get(m - 1).get(i);
            }
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    }
}
