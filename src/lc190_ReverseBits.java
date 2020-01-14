public class lc190_ReverseBits {
    public static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 31; i++) {
                if ((n & 1) == 1) {
                    result++;
                }
                result <<= 1;
                n >>= 1;
            }
            result += n & 1;
            return result;
        }
    }
}
