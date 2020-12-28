package LeetCode_CN;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc_17_13_ReSpaceLCCI {
    static class Solution {
        public int respace(String[] dictionary, String sentence) {
            int n = sentence.length();
            Map<String, Integer> dict = new HashMap<>();
            for (String str: dictionary) {
                dict.put(str, str.length());
            }
            int[] dp = new int[n + 1];
            int maxLen = 0;
            for (int i = 0; i <= n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    String temp = sentence.substring(j, i);
                    if (dict.getOrDefault(temp, 0) > 0) {
                        dp[i] = dp[j] + temp.length();
                        maxLen = Math.max(maxLen, dp[i]);
                    } else {
                        dp[i] = maxLen;
                    }
                }
            }
            return n - maxLen;
        }

        private int findWord(String[] dictionary, String target) {
            int result = 0;
            for (String str: dictionary) {
                if (target.equals(str)) {
                    result = str.length();
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String[] dictionary = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        Solution tool = new Solution();
        int result = tool.respace(dictionary, sentence);
        System.out.println(result);
    }
}
