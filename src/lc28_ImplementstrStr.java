public class lc28_ImplementstrStr {
    static class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0 || needle == null) return 0;
            if (needle.length() > haystack.length()) return -1;
            String temp = "";
            int m = needle.length();
            for (int i = 0; i < haystack.length() - m + 1; i++) {
                temp = haystack.substring(i, i + m);
                if (temp.equals(needle)) return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        Solution tool = new Solution();
        int result = tool.strStr(haystack, needle);
        System.out.println(result);
    }
}
