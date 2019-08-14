public class lc132_PalindromePartitioningII {
    static class Solution {
        public int minCut(String s) {
            int len = s.length();
            int[] cuts = new int[len];
            boolean[][] isPalindrome = new boolean[len][len];

            for (int i = 0; i < len; i++) {
                int min = i;
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                        isPalindrome[j][i] = true;
                        min = j == 0 ? 0 : Math.min(cuts[j - 1] + 1, min);
                    }
                }
                cuts[i] = min;
            }
            return cuts[len - 1];
        }
    }

    public static void main(String[] args) {
        String s = "abbab";
        Solution tool = new Solution();
        int result = tool.minCut(s);
        System.out.println(result);
    }
}
