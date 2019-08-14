public class lc395_LongestSubstringwithAtLeastKRepeatingCharacters {
    static class Solution {
        public int longestSubstring(String s, int k) {
            if (s == null || s.length() == 0 || s.length() < k) return 0;
            int[] bank = new int[256];
            int start = 0;
            int end = 0;
            int max = 0;

            for (int i = 0; i < s.length(); i++) {
                bank[s.charAt(i)]++;
            }

            while (start < s.length() && bank[s.charAt(start)] >= k) {
                start++;
            }
            if (start == s.length()) return s.length();
            int left = longestSubstring(s.substring(0, start), k);
            int right = longestSubstring(s.substring(start + 1), k);
            max = Math.max(left, right);
            return max;
        }
    }

    public static void main(String[] args) {
        String s = "ababacb";
        int k = 3;
        Solution tool = new Solution();
        int result = tool.longestSubstring(s, k);
        System.out.println(result);
    }
}
