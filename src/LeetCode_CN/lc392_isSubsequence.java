package LeetCode_CN;

public class lc392_isSubsequence {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int n1 = s.length();
            int n2 = t.length();
            if (n1 == 0) {
                return true;
            }
            int i = 0;
            int j = 0;
            while (i < n1 && j < n2) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    if (i == n1) {
                        return true;
                    }
                }
                j++;
            }
            return false;
        }
    }
}
