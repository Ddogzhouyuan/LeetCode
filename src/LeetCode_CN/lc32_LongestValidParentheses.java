package LeetCode_CN;

import java.util.Stack;

public class lc32_LongestValidParentheses {
    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length();
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
            int result = 0;
            if (stack.isEmpty()) {
                result = n;
            } else {
                int a = n;
                int b = 0;
                while (!stack.isEmpty()) {
                    b = stack.pop();
                    result = Math.max(result, a - b - 1);
                    a = b;
                }
                result = Math.max(a, result);
            }
            return result;
        }
    }
}
