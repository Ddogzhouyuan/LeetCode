public class lc647_PalindromicSubstrings {
    class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                count += countPalindromes(s, i, i);
                count += countPalindromes(s, i, i+ 1);
            }
            return count;
        }

        private int countPalindromes(String s, int start, int end) {
            int count = 0;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                count++;
                start--;
                end++;
            }
            return count;
        }
    }
}
