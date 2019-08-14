public class lc69_Sqrtx {
    static class Solution {
        public int mySqrt(int x) {
            long a = x;
            while (a * a > x) {
                a = (a + x / a) / 2;
            }
            return (int) a;
        }
    }

    public static void main(String[] args) {
        int x = 96786;
        Solution tool = new Solution();
        int result = tool.mySqrt(x);
        System.out.println(result);
    }
}
