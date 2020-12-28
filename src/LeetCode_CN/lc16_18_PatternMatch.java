package LeetCode_CN;

public class lc16_18_PatternMatch {
    class Solution {
        public boolean patternMatching(String pattern, String value) {
            String[] s = new String[2];
            return backtrack(s, pattern, 0, value, 0);
        }

        private boolean backtrack(String[] s, String pattern, int index1, String value, int index2) {
            if (index1 == pattern.length() && index2 == value.length()) {
                return true;
            }
            if (index1 >= pattern.length() || index2 > value.length()) {
                return false;
            }
            int num = pattern.charAt(index1) - 'a';
            if (s[num] == null) {
                for (int i = index2; i <= value.length(); i++) {
                    s[num] = value.substring(index2, i);
                    if (!s[num].equals(s[num ^ 1]) && backtrack(s, pattern, index1 + 1, value, i)) {
                        return true;
                    }
                }
                s[num] = null;
                return false;
            } else {
                int end = index2 + s[num].length();
                if (end > value.length() || !value.substring(index2, end).equals(s[num])) {
                    return false;
                }
                return backtrack(s, pattern, index1 + 1, value, end);
            }
        }
    }
}
