import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc22_GenerateParentheses_DP {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<List<String>> lists = new ArrayList<>();
            if (n <= 0) return new ArrayList<>();
            lists.add(Arrays.asList(""));
            for (int i = 1; i <= n; i++) {
                List<String> list = new ArrayList<>();

                for (int j = 0; j < i; j++) {
                    for (String first: lists.get(j)) {
                        for (String second: lists.get(i - 1 - j)) {
                            list.add("(" + first + ")" + second);
                        }
                    }
                }
                lists.add(new ArrayList<>(list));
            }


            return lists.get(n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution tool = new Solution();
        List<String> result = tool.generateParenthesis(n);
        for (String i: result) {
            System.out.println(i);
        }
    }
}
