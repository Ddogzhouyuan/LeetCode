import java.util.HashMap;

public class lc242_ValidAnagram {
    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.equals(t)) return true;
            if (s.length() != t.length()) return false;
            int[] ls1 = new int[26];
            int[] ls2 = new int[26];
            for (int i = 0; i < s.length(); i++) {
                ls1[s.charAt(i) - 97] += 1;
                ls2[t.charAt(i) - 97] += 1;
            }
            for (int i = 0; i < ls1.length; i++) {
                if (ls1[i] != ls2[i]) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "cat";
        String t = "rat";
        Solution tool = new Solution();
        boolean result = tool.isAnagram(s, t);
        System.out.println(result);
    }
}
