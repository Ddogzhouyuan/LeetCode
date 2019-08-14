import java.util.Stack;

public class lc316_RemoveDuplicateLetters {
    static class Solution {
        public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            char[] cs = s.toCharArray();
            for (char c: cs) {
                count[c - 'a']++;
            }

            boolean[] visited = new boolean[26];

            Stack<Character> result = new Stack<>();

            for (char c: cs) {
                count[c - 'a']--;
                if (visited[c - 'a']) {
                    continue;
                } else {
                    while (!result.isEmpty() && count[result.peek() - 'a'] > 0 && c < result.peek()) {
                        visited[result.peek() - 'a'] = false;
                        result.pop();
                    }
                    result.push(c);
                    visited[c - 'a'] = true;
                }
            }
            String str = "";
            for (char c: result) {
                str += String.valueOf(c);
            }
            return str;
        }
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        Solution tool = new Solution();
        String result = tool.removeDuplicateLetters(s);
        System.out.println(result);
    }
}
