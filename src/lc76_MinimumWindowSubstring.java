public class lc76_MinimumWindowSubstring {
    static class Solution {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
            int[] bank = new int[256];
            int left = 0;
            int right = 0;
            int count = 0;

            int min = Integer.MAX_VALUE;
            String minString = "";

            for (int i = 0; i < t.length(); i++) {
                bank[t.charAt(i)]++;
            }

            while (right < s.length()) {
                if (bank[s.charAt(right++)]-- > 0) count++;

                while (count == t.length()) {
                    if (min > right - left) {
                        min = right - left;
                        minString = s.substring(left, right);
                    }

                    if (++bank[s.charAt(left++)] > 0) {
                        count--;
                    }
                }
            }
            return minString;
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution tool = new Solution();
        String result = tool.minWindow(s, t);
        System.out.println(result);
    }
}
