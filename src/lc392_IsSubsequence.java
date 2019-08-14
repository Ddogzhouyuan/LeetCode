public class lc392_IsSubsequence {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) return true;
            int indexS = 0;
            int indexT = 0;
            while (indexT < t.length()) {
                if (t.charAt(indexT) == s.charAt(indexS)) {
                    indexS++;
                    if (indexS == s.length()) return true;
                }
                indexT++;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        Solution tool = new Solution();
        boolean result = tool.isSubsequence(s, t);
        System.out.println(result);
    }
}
