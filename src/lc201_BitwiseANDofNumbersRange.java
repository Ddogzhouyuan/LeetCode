public class lc201_BitwiseANDofNumbersRange {
    static class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int d = Integer.MAX_VALUE;
            while ((m & d) != (n & d)) {
                d <<= 1;
            }
            return m & d;
        }
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        Solution tool = new Solution();
        int result = tool.rangeBitwiseAnd(m, n);
        System.out.println(result);
    }
}
