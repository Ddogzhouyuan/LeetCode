public class lc371_SumofTwoIntegers {
    static class Solution {
        public int getSum(int a, int b) {
            int sum = 0, carry = 0;

            for (int i = 0; i < 32; i++) {
                int a1 = a & (1 << i);
                int b1 = b & (1 << i);
                sum |= a1 ^ b1 ^ carry;
                carry = ((a1 & b1) | (b1 & carry) | (a1 & carry)) << 1;
            }

            return sum;
        }
    }
}
