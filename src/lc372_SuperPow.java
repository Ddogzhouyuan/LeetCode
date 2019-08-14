public class lc372_SuperPow {
    static class Solution {
        int base = 1337;
        public int superPow(int a, int[] b) {
            if (b.length == 0) return 1;
            int last_digit = b[b.length - 1];
            int[] newb = new int[b.length - 1];
            for (int i = 0; i < newb.length; i++) {
                newb[i] = b[i];
            }
            return powmod(superPow(a, newb), 10) * powmod(a, last_digit) % base;
        }

        public int powmod(int a, int k) {
            a %= base;
            int result = 1;
            for (int i = 0; i < k; i++) {
                result = (result * a) % base;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int[] b = {6,6,6};
        Solution tool = new Solution();
        int result = tool.superPow(a, b);
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE);
    }
}
