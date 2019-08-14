public class lc231_PowerofTwo {
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            int temp = n;
            while (temp >= 2) {
                if (temp % 2 != 0) return false;
                temp = temp / 2;
            }
            if (temp == 1) {
                return true;
            } else {
                return false;
            }

        }
    }

    public static void main(String[] args) {
        int n = 16;
        Solution tool = new Solution();
        boolean result = tool.isPowerOfTwo(n);
        System.out.println(result);
    }
}
