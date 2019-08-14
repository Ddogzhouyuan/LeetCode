import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc241_DifferentWaystoAddParentheses {
    static class Solution {
        HashMap<String, List<Integer>> map = new HashMap<>();
        public List<Integer> diffWaysToCompute(String input) {
            if (map.containsKey(input)) return map.get(input);

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                    String part1 = input.substring(0, i);
                    String part2 = input.substring(i + 1);

                    List<Integer> part1Res = diffWaysToCompute(part1);
                    List<Integer> part2Res = diffWaysToCompute(part2);

                    for (Integer p1: part1Res) {
                        for (Integer p2: part2Res) {
                            int c = 0;
                            if (input.charAt(i) == '+') {
                                c = p1 + p2;
                            } else if (input.charAt(i) == '-') {
                                c = p1 - p2;
                            } else {
                                c = p1 * p2;
                            }
                            result.add(c);
                        }
                    }
                }
            }

            if (result.size() == 0) {
                result.add(Integer.valueOf(input));
            }
            map.put(input, result);
            return result;
        }
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        Solution tool = new Solution();
        List<Integer> result = tool.diffWaysToCompute(input);
        System.out.println(result.toString());
    }
}
