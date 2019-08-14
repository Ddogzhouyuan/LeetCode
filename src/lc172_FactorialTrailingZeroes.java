public class lc172_FactorialTrailingZeroes {
    static class Solution {
        public int trailingZeroes(int n) {
            int result = 0;
            for (long i = 5; n / i > 0 ; i *= 5) {
                result += n / i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int n = 12312;
        Solution tool = new Solution();
        int result = tool.trailingZeroes(n);
        System.out.println(result);
    }
}
