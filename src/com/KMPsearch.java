package com;

public class KMPsearch {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int[] next = getNextArray(s);
            int result = KmpSearch(t, s, next);
            if (result < 0) {
                return false;
            } else {
                return true;
            }
        }

        public int[] getNextArray(String s) {
            int len = s.length();
            int[] next = new int[len];
            next[0] = -1;

            int k = -1;
            int j = 0;
            while (j < len - 1) {
                if (k == -1 || s.charAt(j) == s.charAt(k)) {
                    j++;
                    k++;
                    if (s.charAt(j) != s.charAt(k)) {
                        next[j] = k;
                    } else {
                        next[j] = next[k];
                    }
                } else {
                    k = next[k];
                }

            }
            return next;
        }

        public int KmpSearch(String s, String p, int[] next) {
            int i = 0;
            int j = 0;
            int slen = s.length();
            int plen = p.length();

            while (i < slen && j < plen) {
                if (j == -1 || s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }

            if (j == plen) {
                return i - j;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "lkjabscsde";
        Solution tool = new Solution();
        boolean result = tool.isSubsequence(s, t);
        System.out.println(result);
    }
}
