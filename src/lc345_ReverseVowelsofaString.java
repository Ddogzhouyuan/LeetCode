import java.util.Arrays;
import java.util.List;

public class lc345_ReverseVowelsofaString {
    static class Solution {
        public String reverseVowels(String s) {
            List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U') ;
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (vowels.contains(s.charAt(i))) cnt++;
            }
            int[] vowelsidx = new int[cnt];
            int idx = 0;
            for (int i = 0; i < s.length(); i++) {
                if (vowels.contains(s.charAt(i))) {
                    vowelsidx[idx++] = i;
                }
            }
            for (int i = 0; i < vowelsidx.length / 2; i++) {
                int i_reverse = vowelsidx.length - 1 - i;
                int temp = vowelsidx[i];
                vowelsidx[i] = vowelsidx[i_reverse];
                vowelsidx[i_reverse] = temp;
            }
            char[] vowels_reverse = new char[cnt];
            idx = 0;
            for (int i: vowelsidx) vowels_reverse[idx++] = s.charAt(i);
            idx = 0;
            StringBuilder sBuilder = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                if (vowels.contains(s.charAt(i))) {
                    sBuilder.setCharAt(i, vowels_reverse[idx++]);
                }
            }
            String result = sBuilder.toString();
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "aA";
        Solution tool = new Solution();
        String result = tool.reverseVowels(s);
        System.out.println(result);
    }
}
