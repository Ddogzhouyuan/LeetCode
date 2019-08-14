public class lc326_PowerofThree {
    static class Solution {
        public boolean isPowerOfThree(int n) {
            int temp = n;
            while (temp >= 3) {
                if (temp % 3 != 0) return false;
                temp = temp / 3;
            }
            if (temp == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 0;
        Solution tool = new Solution();
        boolean result = tool.isPowerOfThree(n);
        System.out.println(result);
    }
}
