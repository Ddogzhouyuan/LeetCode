import java.util.Stack;

public class lc224_BasicCalculator {
    static class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            Stack<Boolean> signStack = new Stack<>();
            int curNum = 0;
            int cur = 0;
            boolean isPositive = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.push(cur);
                    signStack.push(isPositive);
                    cur = 0;
                    curNum = 0;
                    isPositive = true;
                } else if (c == '+') {
                    isPositive = true;
                } else if (c == '-') {
                    isPositive = false;
                } else if (c == ')') {
                    cur = stack.pop() + (signStack.pop() ? 1 : -1) * cur;
                    curNum = 0;
                } else if (c - '0' >= 0 && c - '0' <= 9) {
                    curNum *= 10;
                    curNum += c - '0';
                    if (i != s.length() - 1) {
                        char nextChar = s.charAt(i + 1);
                        if (nextChar < '0' || nextChar > '9') {
                            cur += (isPositive ? 1 : -1) * curNum;
                            curNum = 0;
                        }
                    } else {
                        cur += (isPositive ? 1 : -1) * curNum;
                        curNum = 0;
                    }
                }
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        Solution tool = new Solution();
        int result = tool.calculate(s);
        System.out.println(result);
    }
}
