import java.util.ArrayList;
import java.util.List;

public class lc301_RemoveInvalidParentheses {
    static class Solution {
        public List<String> removeInvalidParentheses(String s) {
            int l = 0;
            int r = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') l++;
                if (l == 0) {
                    if (s.charAt(i) == ')') r++;
                } else {
                    if (s.charAt(i) == ')') l--;
                }
            }

            List<String> result = new ArrayList<>();
            dfs(s, 0, l, r, result);
            return result;
        }

        private boolean isValid(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') count++;
                if (s.charAt(i) == ')') count--;
                if (count < 0) return false;
            }
            return count == 0;
        }

        private void dfs(String s, int start, int l, int r, List<String> result) {
            if (l == 0 && r == 0 && isValid(s)) {
                result.add(s);
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;

                if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                    String curr = s.substring(0, i) + s.substring(i + 1);
                    if (r > 0) {
                        dfs(curr, i, l, r - 1, result);
                    } else if (l > 0) {
                        dfs(curr, i, l - 1, r, result);
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        Solution tool = new Solution();
        List<String> result = tool.removeInvalidParentheses(s);
        for (String i: result) {
            System.out.println(i);
        }
    }
}
