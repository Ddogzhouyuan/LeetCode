public class lc8_StringtoInteger_atoi {
    static class Solution {
        public int myAtoi(String str) {
            int sign = 1;
            int base = 0;
            int i = 0;
            str = str.trim();
            if (str.length() == 0) return 0;
            if (str.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (str.charAt(i) == '+') {
                sign = 1;
                i++;
            } else {
                sign = 1;
            }
            while (i< str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                    if (sign == 1) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
                base = 10 * base + (str.charAt(i++) - '0');
            }

            return base * sign;
        }
    }

    public static void main(String[] args) {
        String str = "+1";
        Solution tool = new Solution();
        int result = tool.myAtoi(str);
        System.out.println(result);
    }
}
