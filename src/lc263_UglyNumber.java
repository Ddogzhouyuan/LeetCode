public class lc263_UglyNumber {
    static class Solution {
        public boolean isUgly(int num) {
            if (num == 1) return true;
            if (num <= 0) return false;
            if (num == 2 || num == 3 || num == 5) return true;
            if (num % 2 == 0) {
                return isUgly(num / 2);
            } else if (num % 3 == 0) {
                return isUgly(num / 3);
            } else if (num % 5 == 0) {
                return isUgly(num / 5);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int num = 100;
        Solution tool = new Solution();
        boolean result = tool.isUgly(num);
        System.out.println(result);
    }
}
