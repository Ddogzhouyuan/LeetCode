public class lc397_IntegerReplacement {
    static class Solution {
        public int integerReplacement(int n) {
            int result = backtrack(n, 0);
            return result;
        }

        public int backtrack(long n, int ops) {
            if (n == 1) return ops;
            if (n % 2 == 0) {
                return backtrack(n / 2, ops + 1);
            } else {
                int plus = backtrack(n + 1, ops + 1);
                int left = backtrack(n - 1, ops + 1);
                return Math.min(plus, left);
            }
        }
    }

    public static void main(String[] args) {
        int n = 2147483647;
        Solution tool = new Solution();
        int result = tool.integerReplacement(n);
        System.out.println(result);
    }
}
