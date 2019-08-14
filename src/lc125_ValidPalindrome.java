public class lc125_ValidPalindrome {
    static class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                    sb.append(String.valueOf(s.charAt(i)));
                }
            }
            String str = sb.toString();
            String str2 = sb.reverse().toString();
            if (str.equals(str2) || (str == "" && str2 == "")) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "0P";
        Solution tool = new Solution();
        boolean result = tool.isPalindrome(s);
        System.out.println(result   );
    }
}
