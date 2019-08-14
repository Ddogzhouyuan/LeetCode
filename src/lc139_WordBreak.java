import java.util.Arrays;
import java.util.List;

public class lc139_WordBreak {
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j]) {
                        String substr = s.substring(j, i);
                        if (wordDict.contains(substr)) {
                            dp[i] = true;
                        }
                    }
                }
            }
            return dp[s.length()];
        }
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        Solution tool = new Solution();
        boolean result = tool.wordBreak(s, wordDict);
        System.out.println(result);
    }
}
