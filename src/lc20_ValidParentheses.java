import java.util.HashMap;
import java.util.Stack;

public class lc20_ValidParentheses {
    static class Solution {
        public boolean isValid(String s) {
            HashMap<String, String> hashmap = new HashMap<>();
            Stack<String> stack = new Stack<>();
            if (s.length() == 1) return false;
            hashmap.put(")", "(");
            hashmap.put("]", "[");
            hashmap.put("}", "{");
            for (int i = 0; i < s.length(); i++) {
                String temp = String.valueOf(s.charAt(i));
                if (hashmap.containsValue(temp)) {
                    stack.push(temp);
                } else if (hashmap.containsKey(temp)) {
                    if (stack.isEmpty() || !stack.pop().equals(hashmap.get(temp))) return false;
                } else {
                    return false;
                }
            }
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "";
        Solution tool = new Solution();
        boolean result = tool.isValid(s);
        System.out.println(result);
    }
}
