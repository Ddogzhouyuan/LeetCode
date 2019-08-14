public class lc50_Powxn {
    static class Solution {
        public double myPow(double x, int n) {
            if (n == 0) return 1;
            if (n == Integer.MIN_VALUE) return myPow(x * x, n / 2);
            if (n < 0) {
                n = -n;
                x = 1 / x;
            }
            if (n % 2 == 1) {
                return x * myPow(x * x, n / 2);
            } else {
                return myPow(x * x, n / 2);
            }
        }
    }

    public static void main(String[] args) {
        double x = 23;
        int n = 3;
        Solution tool = new Solution();
        double result = tool.myPow(x, n);
        System.out.println(result);
    }
}
