package LeetCode_CN;

import java.util.List;

public class lc139_WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j]) {
                        String temp = s.substring(j, i);
                        if (wordDict.contains(temp)) {
                            dp[i] = true;
                        }
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
