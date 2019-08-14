public class lc67_AddBinary {
    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int lena = a.length();
            int lenb = b.length();
            int length = Math.max(lena, lenb);
            if (length > lena) {
                int i = 0;
                while (i < length - lena) {
                    a = "0" + a;
                    i++;
                }
            } else if (length > lenb) {
                int i = 0;
                while (i < length - lenb) {
                    b = "0" + b;
                    i++;
                }
            }
            int trans = 0;
            for (int i = length - 1; i >= 0; i--) {
                int tempa = Integer.valueOf(a.charAt(i) - '0');
                int tempb = Integer.valueOf(b.charAt(i) - '0');
                int tempi = tempa + tempb + trans;
                if (tempi == 3) {
                    result.append("1");
                    trans = 1;
                } else if (tempi == 2) {
                    result.append("0");
                    trans = 1;
                } else if (tempi == 1) {
                    result.append("1");
                    trans = 0;
                } else {
                    result.append("0");
                    trans = 0;
                }
            }
            if (trans == 1) result.append("1");
            return result.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String a = "101";
        String b = "1011";
        Solution tool = new Solution();
        String result = tool.addBinary(a, b);
        System.out.println(result);
    }
}
