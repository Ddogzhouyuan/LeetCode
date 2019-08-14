public class lc342_PowerofFour {
    static class Solution {
        public boolean isPowerOfFour(int num) {
            int temp = num;
            while (temp >= 4) {
                if (temp % 4 != 0) return false;
                temp = temp / 4;
            }
            if (temp == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        int num = 5;
        Solution tool = new Solution();
        boolean result = tool.isPowerOfFour(num);
        System.out.println(result);
    }
}
