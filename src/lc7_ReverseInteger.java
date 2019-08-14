public class lc7_ReverseInteger {
    static class Solution {
        public int reverse(int x) {
            String x_str = "";
            StringBuilder x_r = new StringBuilder();
            long ans = 0;
            if (x >= 0) {
                x_str = Integer.toString(x);
                for (int i = x_str.length() - 1; i >= 0; i--) {
                    x_r.append(x_str.charAt(i));
                }
                x_str = x_r.toString();
                ans = Long.parseLong(x_str);
            } else {
                x_str = Integer.toString(x);
                x_r.append(x_str.charAt(0));
                for (int i = x_str.length() - 1; i >= 1; i--) {
                    x_r.append(x_str.charAt(i));
                }
                x_str = x_r.toString();
                ans = Long.parseLong(x_str);
            }
            if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
                return 0;
            } else {
                return (int) ans;
            }
        }
    }
}
