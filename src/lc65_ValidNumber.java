import java.util.*;

public class lc65_ValidNumber {
    static class Solution {
        public boolean isNumber(String s) {
            List<HashMap<String, Integer>> state = new LinkedList<>();
            HashMap<String, Integer> temp = new HashMap<>();
            state.add(new HashMap<>(temp));
            temp.put("blank", 1);
            temp.put("sign", 2);
            temp.put("digit", 3);
            temp.put(".", 4);
            state.add(new HashMap<>(temp));
            temp = new HashMap<>();
            temp.put("digit", 3);
            temp.put(".", 4);
            state.add(new HashMap<>(temp));
            temp = new HashMap<>();
            temp.put("digit", 3);
            temp.put(".", 5);
            temp.put("e", 6);
            temp.put("blank", 9);
            state.add(new HashMap<>(temp));
            temp = new HashMap<>();
            temp.put("digit", 5);
            state.add(new HashMap<>(temp));
            temp = new HashMap<>();
            temp.put("digit", 5);
            temp.put("e", 6);
            temp.put("blank", 9);
            state.add(new HashMap<>(temp));
            temp = new HashMap<>();
            temp.put("sign", 7);
            temp.put("digit", 8);
            state.add(new HashMap<>(temp));
            temp = new HashMap<>();
            temp.put("digit", 8);
            state.add(new HashMap<>(temp));
            temp = new HashMap<>();
            temp.put("digit", 8);
            temp.put("blank", 9);
            state.add(new HashMap<>(temp));
            temp = new HashMap<>();
            temp.put("blank", 9);
            state.add(new HashMap<>(temp));

            int currentState = 1;
            for (int i = 0; i < s.length(); i++) {
                String str_i = String.valueOf(s.charAt(i));
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    str_i = "digit";
                } else if (s.charAt(i) == ' ') {
                    str_i = "blank";
                } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                    str_i = "sign";
                }
                if (!state.get(currentState).containsKey(str_i)) {
                    return false;
                }
                currentState = state.get(currentState).get(str_i);
            }
            Set<Integer> set1 = new HashSet<>(Arrays.asList(3, 5, 8, 9));

            if (!set1.contains(currentState)) return false;
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "3.";
        Solution tool = new Solution();
        boolean result = tool.isNumber(s);
        System.out.println(result);
    }
}
