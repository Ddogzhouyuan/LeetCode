package LeetCode_CN;

public class lc67_AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            int carry = 0;
            int aLen = a.length();
            int bLen = b.length();
            StringBuilder sb = new StringBuilder();
            int maxLen = Math.max(aLen, bLen);
            while (a.length() < maxLen) {
                a = "0" + a;
            }
            while (b.length() < maxLen) {
                b = "0" + b;
            }
            for (int i = maxLen - 1; i >= 0; i--) {
                int aPos = a.charAt(i) - '0';
                int bPos = b.charAt(i) - '0';
                int temp = aPos + bPos + carry;
                if (temp == 3) {
                    carry = 1;
                    sb.append(1);
                }
                if (temp == 2) {
                    carry = 1;
                    sb.append(0);
                }
                if (temp == 1) {
                    carry = 0;
                    sb.append(1);
                }
                if (temp == 0) {
                    carry = 0;
                    sb.append(0);
                }
            }
            if (carry > 0) {
                sb.append(1);
            }
            return sb.reverse().toString();
        }
    }
}
