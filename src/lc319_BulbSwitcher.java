public class lc319_BulbSwitcher {
    static class Solution {
        public int bulbSwitch(int n) {
            int result = 0;
            result = mySqrt(n);
            return result;
        }

        public int mySqrt(int x) {
            long a = x;
            while (a * a > x) {
                a = (a + x / a) / 2;
            }
            return (int) a;
        }

        public int numberoffactors(int n) {
            if (n == 1) return 1;
            int count = 2;
            int sqrt = mySqrt(n);
            int r = 0;
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    r = n / i;
                    if (r == sqrt) {
                        count++;
                    } else {
                        count += 2;
                    }
                } else {
                    count += 2;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        Solution tool = new Solution();
        int result = tool.bulbSwitch(n);
        System.out.println(result);
    }
}
