public class lc343_IntegerBreak {
    static class Solution {
        public int integerBreak(int n) {
            if (n == 2) return 1;
            if (n == 3) return 2;
            int max = 1;
            for (int i = 2; i <= n / 2; i++) {
                int num1 = n / i;
                int num2 = n / i + 1;
                int count1 = i - n % i;
                int count2 = n % i;
                int part1 = 1;
                int part2 = 1;
                while (count1 > 0) {
                    part1 *= num1;
                    count1--;
                }
                while (count2 > 0) {
                    part2 *= num2;
                    count2--;
                }
                max = Math.max(max, part1 * part2);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int n = 19;
        Solution tool = new Solution();
        int result = tool.integerBreak(n);
        System.out.println(result);
    }
}
