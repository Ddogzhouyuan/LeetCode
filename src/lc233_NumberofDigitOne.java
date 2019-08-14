public class lc233_NumberofDigitOne {
    static class Solution {
        public int countDigitOne(int n) {
            int ones = 0;
            for (long m = 1; m <= n; m *= 10) {
                long a = n / m;
                long b = n % m;
                if (a % 10 == 1) {
                    ones += (a + 8) / 10 * m + (b + 1);
                } else {
                    ones += (a + 8) / 10 * m;
                }
            }
            return ones;
        }
    }

    public static void main(String[] args) {
        int n = 1410065408;
        Solution tool = new Solution();
        int result = tool.countDigitOne(n);
        System.out.println(result);
    }
}
