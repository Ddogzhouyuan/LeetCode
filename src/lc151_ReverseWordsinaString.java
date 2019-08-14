public class lc151_ReverseWordsinaString {
    public static class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] s_ls = s.split(" ");
            int cnt = 0;
            for (String i: s_ls) {
                if (i.length() > 0) cnt++;
            }
            String[] s_ls2 = new String[cnt];
            int idx = 0;
            for (int i = 0; i < s_ls.length; i++) {
                if (s_ls[i].length() > 0) {
                    s_ls2[idx++] = s_ls[i];
                }
            }
            String temp = "";
            for (int i = 0; i < s_ls2.length / 2; i++) {
                int i_reverse = s_ls2.length - 1 - i;
                temp = s_ls2[i_reverse];
                s_ls2[i_reverse] = s_ls2[i];
                s_ls2[i] = temp;
            }
            String result = String.join(" ", s_ls2);
            return result;
        }
    }

    public static void main(String[] args) {
        String s = " ";
        Solution tool = new Solution();
        String result = tool.reverseWords(s);
        System.out.println(result);
    }
}
