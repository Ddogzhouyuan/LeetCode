public class lc115_DistinctSubsequences {
    static class Solution {
        public int numDistinct(String s, String t) {
            int[][] mem = new int[t.length() + 1][s.length() + 1];
            for (int i = 0; i < s.length(); i++) {
                mem[0][i] = 1;
            }

            for (int i = 0; i < t.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                    if (s.charAt(j) == t.charAt(i)) {
                        mem[i + 1][j + 1] += mem[i][j];
                    }
                }
            }
            return mem[t.length()][s.length()];
        }
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        Solution tool = new Solution();
        int result = tool.numDistinct(s, t);
        System.out.println(result);
    }
}
