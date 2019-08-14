import java.util.ArrayList;
import java.util.List;

public class lc131_PalindromePartitioning {
    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            List<String> temp_result = new ArrayList<>();
            if (s == null || s.length() == 0) return result;
            backtrack(result, temp_result, s, 0);
            return result;
        }

        public boolean judgePalindrome(String s) {
            StringBuilder temp = new StringBuilder();
            for (int i = s.length() - 1; i  >= 0; i--) {
                temp.append(s.charAt(i));
            }
            boolean res = s.equals(temp.toString());
            return res;
        }

        public void backtrack(List<List<String>> result, List<String> temp_result, String s, int start) {
            if (start == s.length()) result.add(new ArrayList<>(temp_result));
            for (int i = start; i < s.length(); i++) {
                if (judgePalindrome(s.substring(start, i + 1))){
                    temp_result.add(s.substring(start, i + 1));
                    backtrack(result, temp_result, s, i + 1);
                    temp_result.remove(temp_result.size() - 1);
                }

            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
//        System.out.println(s.substring(0,1));
        Solution tool = new Solution();
        List<List<String>> result = tool.partition(s);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
