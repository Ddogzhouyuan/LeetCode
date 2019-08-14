import java.util.Stack;

public class lc227_BasicCalculatorII {
    static class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char sign = '+';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    int cur = c - '0';
                    num = num * 10 + cur;
                }

                if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                    if (sign == '+') {
                        stack.push(num);
                    } else if (sign == '-') {
                        stack.push(-num);
                    } else if (sign == '*') {
                        stack.push(stack.pop() * num);
                    } else if (sign == '/') {
                        stack.push(stack.pop() / num);
                    }
                    num = 0;
                    sign = c;
                }
            }
            int sum = 0;
            while (!stack.isEmpty()) sum += stack.pop();
            return sum;
        }
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        Solution tool = new Solution();
        int result = tool.calculate(s);
        System.out.println(result);
    }
}
