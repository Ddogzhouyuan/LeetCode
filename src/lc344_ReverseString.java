import java.util.Arrays;

public class lc344_ReverseString {
    static class Solution {
        public void reverseString(char[] s) {
            if (s.length <= 1 || s == null) return;
            char temp = 'a';
            for (int i = 0; i < s.length / 2; i++) {
                int i_reverse = s.length - 1 - i;
                temp = s[i_reverse];
                s[i_reverse] = s[i];
                s[i] = temp;
            }
            System.out.println(Arrays.toString(s));
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l'};
        Solution tool = new Solution();
        tool.reverseString(s);
    }
}
