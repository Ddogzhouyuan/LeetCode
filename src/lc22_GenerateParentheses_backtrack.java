import java.util.ArrayList;
import java.util.List;

public class lc22_GenerateParentheses_backtrack {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            if (n == 0) return result;
            backtrack(0, 0, n, result, new StringBuilder());
            return result;
        }

        public void backtrack(int usedOpen, int usedClose, int n, List<String> result, StringBuilder currentStr) {
            if (usedClose == n && usedOpen == n) {
                result.add(currentStr.toString());
            }

            if (usedOpen < n) {
                currentStr.append("(");
                usedOpen++;
                backtrack(usedOpen, usedClose, n, result, currentStr);
                currentStr.deleteCharAt(currentStr.length() - 1);
                usedOpen--;
            }

            if (usedClose < usedOpen) {
                currentStr.append(")");
                usedClose++;
                backtrack(usedOpen, usedClose, n, result, currentStr);
                currentStr.deleteCharAt(currentStr.length() - 1);
                usedClose--;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution tool = new Solution();
        List<String> result = tool.generateParenthesis(n);
        for (String i: result) {
            System.out.println(i);
        }
    }
}
