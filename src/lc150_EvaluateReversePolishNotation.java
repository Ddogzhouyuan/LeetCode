import java.util.Stack;

public class lc150_EvaluateReversePolishNotation {
    static class Solution {
        public int evalRPN(String[] tokens) {
            int temp;
            String token;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                token = tokens[i];
                if (token.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if (token.equals("-")) {
                    temp = stack.pop();
                    stack.push(stack.pop() - temp);
                } else if (token.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (token.equals("/")) {
                    temp = stack.pop();
                    stack.push(stack.pop() / temp);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        Solution tool = new Solution();
        int result = tool.evalRPN(tokens);
        System.out.println(result);
    }
}
