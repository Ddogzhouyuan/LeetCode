public class lc29_DivideTwoIntegers {
    static class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

            long dvd = (long) dividend;
            long dvs = (long) divisor;
            long ans = 0;
            int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

            if (dvd < 0) dvd = -dvd;
            if (dvs < 0) dvs = -dvs;
            while (dvd >= dvs) {
                long temp = dvs;
                int m = 1;
                while (dvd >= (temp << 1)) {
                    temp <<= 1;
                    m <<= 1;
                }
                dvd -= temp;
                ans += m;
            }
            return (int) ans * sign;
        }
    }

    public static void main(String[] args) {
        int dividend = 7;
        int divisor = -3;
        Solution tool = new Solution();
        int result = tool.divide(dividend, divisor);
        System.out.println(result);
    }
}
