import java.util.Stack;

public class problem_hw {
    public static boolean judge(String str) {
        Stack<Character> stack = new Stack<>();
        char[] strArr = str.toCharArray();
        int n = strArr.length;
        for (int i = 0; i < n; i++) {
            if (strArr[i] == '(' || strArr[i] == '{' || strArr[i] == '[' || strArr[i] == '<') {
                stack.push(strArr[i]);
                continue;
            } else if (strArr[i] == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (strArr[i] == '}') {
                if (stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            } else if (strArr[i] == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (strArr[i] == '>') {
                if (stack.isEmpty() || stack.pop() != '<') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{()}>";
        boolean result = judge(str);
        System.out.println(result);
    }
}
