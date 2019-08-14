public class lc367_ValidPerfectSquare {
    static class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1) return true;
            long low = 1;
            long high = num / 2;
            long mid = 0;

            long nums = (long) num;

            while (low <= high) {
                mid = low + (high - low) / 2;
                long temp = mid * mid;
                if (temp == nums) {
                    return true;
                } else if (temp < nums) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int num = 14;
        Solution tool = new Solution();
        boolean result = tool.isPerfectSquare(num);
        System.out.println(result);
    }
}
