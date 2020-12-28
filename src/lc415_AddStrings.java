public class lc415_AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int curry = 0;
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || curry == 1; i--, j--) {
                int x = i < 0 ? 0 : num1.charAt(i) - '0';
                int y = j < 0 ? 0 : num2.charAt(j) - '0';
                sb.append((x + y + curry) % 10);
                curry = (x + y + curry) / 10;
            }
            return sb.reverse().toString();
        }
    }
}
