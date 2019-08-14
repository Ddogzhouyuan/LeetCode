import java.util.Stack;

public class lc32_LongestValidParentheses_stack {
    static class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
            int longest = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }

            if (stack.isEmpty()) {
                longest = n;
            } else {
                int a = n;
                int b = 0;
                while (!stack.isEmpty()) {
                    b = stack.pop();
                    longest = Math.max(longest, a - b - 1);
                    a = b;
                }
                longest = Math.max(longest, a);
            }
            return longest;
        }
    }

    public static void main(String[] args) {
        String s = ")()())";
        Solution tool = new Solution();
        int result = tool.longestValidParentheses(s);
        System.out.println(result);
    }
}
