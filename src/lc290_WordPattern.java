import java.util.HashMap;

public class lc290_WordPattern {
    static class Solution {
        public boolean wordPattern(String pattern, String str) {
            HashMap<Character, String> hashmap = new HashMap<>();
            HashMap<String, Character> hashmap2 = new HashMap<>();
            str = str.trim();
            String[] strLs = str.split(" ");
            if (pattern.length() != strLs.length) return false;
            for (int i = 0; i < pattern.length(); i++) {
                if (hashmap.containsKey(pattern.charAt(i))) {
                    if (!hashmap.get(pattern.charAt(i)).equals(strLs[i])) return false;
                } else {
                    hashmap.put(pattern.charAt(i), strLs[i]);
                }
            }
            for (int i = 0; i < strLs.length; i++) {
                if (hashmap2.containsKey(strLs[i])) {
                    if (!hashmap2.get(strLs[i]).equals(pattern.charAt(i))) return false;
                } else {
                    hashmap2.put(strLs[i], pattern.charAt(i));
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        Solution tool = new Solution();
        boolean result = tool.wordPattern(pattern, str);
        System.out.println(result);
        pattern = "abba";
        str = "dog cat cat fish";
        result = tool.wordPattern(pattern, str);
        System.out.println(result);
        pattern = "aaaa";
        str = "dog cat cat dog";
        result = tool.wordPattern(pattern, str);
        System.out.println(result);
        pattern = "abba";
        str = "dog dog dog dog";
        result = tool.wordPattern(pattern, str);
        System.out.println(result);
    }
}
