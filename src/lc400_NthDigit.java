public class lc400_NthDigit {
    static class Solution {
        public int findNthDigit(int n) {
            int len = 1;
            long count = 9;
            int start = 1;

            while (n > len * count) {
                n -= len * count;
                len++;
                count = count * 10;
                start = start * 10;
            }

            start += (n - 1) / len;
            String s = String.valueOf(start);
            return s.charAt((n - 1) % len) - '0';
        }
    }

    public static void main(String[] args) {
        int n = 180;
        Solution tool = new Solution();
        int result = tool.findNthDigit(n);
        System.out.println(result);
    }
}
