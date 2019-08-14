import java.util.Stack;

public class lc394_DecodeString {
    static class Solution {
        public String decodeString(String s) {
            Stack<Object> stack = new Stack<>();
            int num = 0;
            for (char c : s.toCharArray()) {
                if (isDigit(c)) {
                    num = num * 10 + c - '0';
                } else if (c == '[') {
                    stack.push(num);
                    num = 0;
                } else if (c == ']') {
                    String st = popStack(stack);
                    stack.push(st);
                } else {
                    stack.push(c);
                }
            }
            return popStack(stack);
        }

        public boolean isDigit(char c) {
            return '0' <= c && c <= '9';
        }

        public String popStack(Stack<Object> stack) {
            Stack<Object> buffer = new Stack<>();
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && !(stack.peek() instanceof Integer)) {
                buffer.push(stack.pop());
            }
            while (!buffer.isEmpty()) {
                sb.append(buffer.pop());
            }
            int cnt = stack.isEmpty() ? 1 : (int) stack.pop();
            if (cnt == 0) {
                return "";
            }
            String temp = sb.toString();
            for (int i = 0; i < cnt - 1; i++) {
                sb.append(temp);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        Solution tool = new Solution();
        String result = tool.decodeString(s);
        System.out.println(result);
    }
}
