public class lc357_CountNumberswithUniqueDigits {
    static class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;

            int result = 10;
            int uniqueDigits = 9;
            int availableNumber = 9;
            while (n-- > 1 && availableNumber > 0) {
                uniqueDigits = uniqueDigits * availableNumber;
                result += uniqueDigits;
                availableNumber--;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Solution tool = new Solution();
        int result = tool.countNumbersWithUniqueDigits(n);
        System.out.println(result);
    }
}
