public class lc58_LengthofLastWord {
    static class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            if (s == null || s.length() == 0) return 0;
            String[] s_ls = s.split(" ");
            return s_ls[s_ls.length - 1].length();
        }
    }

    public static void main(String[] args) {
        String s = "Hello world";
        Solution tool = new Solution();
        int result = tool.lengthOfLastWord(s);
        System.out.println(result);
    }
}
