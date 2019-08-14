public class lc38_CountandSay {
    static class Solution {
        public String countAndSay(int n) {
            if (n == 1) return "1";

            char[] re = countAndSay(n - 1).toCharArray();
            int count = 0;
            char cur = re[0];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < re.length; i++) {
                if (cur != re[i]) {
                    sb.append(count);
                    sb.append(cur);
                    cur = re[i];
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count > 0 ? count + String.valueOf(cur) : "");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        Solution tool = new Solution();
        String result = tool.countAndSay(n);
        System.out.println(result);
    }
}
